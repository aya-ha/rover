package com.bnp.rover.robot;

import com.bnp.rover.domain.Command;
import com.bnp.rover.domain.Coordinate;
import com.bnp.rover.domain.Direction;
import com.bnp.rover.domain.Grid;
import com.bnp.rover.exception.IllegalCoordinateException;
import com.bnp.rover.exception.IllegalDataInput;
import com.bnp.rover.factory.CompassFactory;

public class RobotImpl implements Robot {

    public Coordinate create(int x, int y, Direction direction, Grid grid) throws IllegalCoordinateException {
        if(x > grid.getX() ||  x < 0 ||  y > grid.getY() || y < 0) {
            throw new IllegalCoordinateException("Illegal position");
        }
        return new Coordinate(x, y, direction);
    }

    public Coordinate move(Coordinate coordinate) {
        switch(coordinate.getDirection()) {
            case N: coordinate.setY(coordinate.getY() + 1); break;
            case S: coordinate.setY(coordinate.getY() - 1); break;
            case E: coordinate.setX(coordinate.getX() + 1); break;
            case W: coordinate.setX(coordinate.getX() - 1); break;
        }
        return coordinate;
    }

    public Coordinate rotate(Coordinate coordinate, Command c) throws IllegalDataInput {
        switch (c) {
            case L: coordinate.setDirection(CompassFactory.getCompassFactory(coordinate.getDirection()).goToTheLeft()); break;
            case R: coordinate.setDirection(CompassFactory.getCompassFactory(coordinate.getDirection()).goToTheRight()); break;
        }
        return coordinate;
    }

    public boolean isMovementAllowed(Coordinate coordinate, Grid grid) {
        if(coordinate.getDirection() == Direction.N && coordinate.getY() + 1 > grid.getY()) return false;
        else if (coordinate.getDirection() == Direction.E && coordinate.getX() + 1 > grid.getX()) return false;
        else if (coordinate.getDirection() == Direction.S && coordinate.getY() - 1 < 0) return false;
        else if (coordinate.getDirection() == Direction.W && coordinate.getX() - 1 < 0) return false;
        return true;
    }
}

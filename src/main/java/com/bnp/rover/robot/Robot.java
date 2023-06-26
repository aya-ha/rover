package com.bnp.rover.robot;

import com.bnp.rover.domain.Command;
import com.bnp.rover.domain.Coordinate;
import com.bnp.rover.domain.Direction;
import com.bnp.rover.domain.Grid;
import com.bnp.rover.exception.IllegalCoordinateException;
import com.bnp.rover.exception.IllegalDataInput;

public interface Robot {

    Coordinate create(int x, int y, Direction direction, Grid grid) throws IllegalCoordinateException;
    Coordinate move(Coordinate coordinate);
    Coordinate rotate(Coordinate coordinate, Command c) throws IllegalDataInput;
    boolean isMovementAllowed(Coordinate coordinate, Grid grid);
}

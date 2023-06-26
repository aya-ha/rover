package com.bnp.rover.robot;


import com.bnp.rover.domain.Command;
import com.bnp.rover.domain.Coordinate;
import com.bnp.rover.domain.Direction;
import com.bnp.rover.domain.Grid;
import com.bnp.rover.exception.IllegalCoordinateException;
import com.bnp.rover.exception.IllegalDataInput;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(JUnit4.class )
public class RobotImplTest {

    private Robot robot;

    @Before
    public void before() {
        this.robot = new RobotImpl();
    }

    @Test
    public void createCoordinateForRobot() throws IllegalCoordinateException {
        // given
        int x = 3;
        int y = 3;
        Direction d = Direction.N;
        Grid grid = new Grid(10,10);

        // when
        Coordinate coordinate = this.robot.create(x, y, d, grid);

        // then
        assertThat(coordinate.getX()).isEqualTo(3);
        assertThat(coordinate.getY()).isEqualTo(3);
        assertThat(coordinate.getDirection()).isEqualTo(Direction.N);
    }

    @Test(expected = IllegalCoordinateException.class)
    public void throwExceptionWhenRobotOutsideGrid() throws IllegalCoordinateException {
        // given
        int x = 6;
        int y = 3;
        Direction d = Direction.N;
        Grid grid = new Grid(5,5);

        // when
        Coordinate coordinate = this.robot.create(x, y, d, grid);
    }

    @Test
    public void moveToNorth() {
        // given
        Coordinate  coordinate = new Coordinate(3, 3, Direction.N);

        // when
        coordinate = this.robot.move(coordinate);

        // then
        assertThat(coordinate.getX()).isEqualTo(3);
        assertThat(coordinate.getY()).isEqualTo(4);
    }

    @Test
    public void moveToSouth() {
        // given
        Coordinate  coordinate = new Coordinate(3, 3, Direction.S);

        // when
        coordinate = this.robot.move(coordinate);

        // then
        assertThat(coordinate.getX()).isEqualTo(3);
        assertThat(coordinate.getY()).isEqualTo(2);
    }

    @Test
    public void moveToEst() {
        // given
        Coordinate  coordinate = new Coordinate(3, 3, Direction.E);

        // when
        coordinate = this.robot.move(coordinate);

        // then
        assertThat(coordinate.getX()).isEqualTo(4);
        assertThat(coordinate.getY()).isEqualTo(3);
    }

    @Test
    public void moveToWest() {
        // given
        Coordinate  coordinate = new Coordinate(3, 3, Direction.W);

        // when
        coordinate = this.robot.move(coordinate);

        // then
        assertThat(coordinate.getX()).isEqualTo(2);
        assertThat(coordinate.getY()).isEqualTo(3);
    }

    @Test
    public void rotateRobotToLeft() throws IllegalDataInput {
        // given
        Coordinate  coordinate = new Coordinate(3, 3, Direction.N);
        Command command = Command.L;

        // when
        coordinate = this.robot.rotate(coordinate, command);

        // then
        assertThat(coordinate.getDirection()).isEqualTo(Direction.W);
    }

    @Test
    public void rotateRobotToRight() throws IllegalDataInput {
        // given
        Coordinate  coordinate = new Coordinate(3, 3, Direction.N);
        Command command = Command.R;

        // when
        coordinate = this.robot.rotate(coordinate, command);

        // then
        assertThat(coordinate.getDirection()).isEqualTo(Direction.E);
    }
}

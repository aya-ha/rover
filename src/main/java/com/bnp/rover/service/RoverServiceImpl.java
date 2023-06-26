package com.bnp.rover.service;

import com.bnp.rover.domain.Command;
import com.bnp.rover.domain.Coordinate;
import com.bnp.rover.domain.Grid;
import com.bnp.rover.exception.IllegalDataInput;
import com.bnp.rover.robot.Robot;

public class RoverServiceImpl implements RoverService {
    private Robot robot;

    public RoverServiceImpl(Robot robot) {
        this.robot = robot;
    }

    public Coordinate executeCommand(Grid grid, Coordinate coordinate, String instruction) {
        try {
            for(int i = 0; i < instruction.length(); i++) {
                switch (instruction.charAt(i)) {
                    case 'M':
                        if (this.robot.isMovementAllowed(coordinate, grid)) {
                            coordinate = this.robot.move(coordinate);
                        }
                        break;
                    case 'L':
                    case 'R':
                        coordinate = this.robot.rotate(coordinate, Command.valueOf(String.valueOf(instruction.charAt(i))));
                        break;
                }
            }
        } catch (IllegalDataInput e) {
            System.out.println("A problem occurs when execute instruction");
        }
        return coordinate;
    }
}

package com.bnp.rover;

import com.bnp.rover.domain.Coordinate;
import com.bnp.rover.domain.Direction;
import com.bnp.rover.domain.Grid;
import com.bnp.rover.exception.IllegalDataInput;
import com.bnp.rover.robot.RobotImpl;
import com.bnp.rover.service.RoverService;
import com.bnp.rover.service.RoverServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    private static RoverService roverService = new RoverServiceImpl(new RobotImpl());
    public static void main( String[] args ) throws IllegalDataInput {
        int i = 0;
        String item[];
        Coordinate c = null;
        Grid grid = null;
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while(scanner.hasNext()) {
                if (i == 0) {
                    String gridXY = scanner.nextLine();
                    item = gridXY.split(" ");
                    if (item == null || item.length != 2) {
                        throw new IllegalDataInput("Incorrect Data input");
                    }
                    grid = new Grid(Integer.parseInt(item[0]), Integer.parseInt(item[1]));
                } else if (i % 2 != 0) {
                    String coordinate = scanner.nextLine();
                    item = coordinate.split(" ");
                    if (item == null || item.length != 3) {
                        throw new IllegalDataInput("Incorrect data input");
                    }
                    c = new Coordinate(Integer.parseInt(item[0]), Integer.parseInt(item[1]), Direction.getDirection(item[2].charAt(0)));
                } else {
                    String instruction = scanner.nextLine();
                    c = roverService.executeCommand(grid, c, instruction);
                    System.out.println(c.getX() + " " + c.getY() + " " + c.getDirection());
                }
                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

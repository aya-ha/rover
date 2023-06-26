package com.bnp.rover.service;

import com.bnp.rover.domain.Coordinate;
import com.bnp.rover.domain.Grid;

public interface RoverService {
    Coordinate executeCommand(Grid grid, Coordinate coordinate, String command);
}

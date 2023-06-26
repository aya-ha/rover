package com.bnp.rover.factory;

import com.bnp.rover.domain.Direction;
import com.bnp.rover.exception.IllegalDataInput;

public class CompassFactory {
    public static Compass getCompassFactory(Direction direction) throws IllegalDataInput {
        switch (direction) {
            case N: return new North();
            case S: return new South();
            case E: return new Est();
            case W: return new West();
            default: throw new IllegalDataInput("Direction not found");
        }
    }
}

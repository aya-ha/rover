package com.bnp.rover.factory;

import com.bnp.rover.domain.Direction;

public class Est extends Compass {
    public Direction getDirection() {
        return Direction.E;
    }

    public Direction goToTheLeft() {
        return Direction.N;
    }

    public Direction goToTheRight() {
        return Direction.S;
    }
}

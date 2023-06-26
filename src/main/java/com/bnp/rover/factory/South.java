package com.bnp.rover.factory;

import com.bnp.rover.domain.Direction;

public class South extends Compass {
    public Direction getDirection() {
        return Direction.S;
    }

    public Direction goToTheLeft() {
        return Direction.E;
    }

    public Direction goToTheRight() {
        return Direction.W;
    }
}

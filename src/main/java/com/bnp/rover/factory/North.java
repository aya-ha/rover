package com.bnp.rover.factory;

import com.bnp.rover.domain.Direction;

public class North extends Compass {

    public Direction getDirection() {
        return Direction.N;
    }

    public Direction goToTheLeft() {
        return Direction.W;
    }

    public Direction goToTheRight() {
        return Direction.E;
    }
}

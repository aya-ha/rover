package com.bnp.rover.factory;

import com.bnp.rover.domain.Direction;

public class West extends Compass {
    public Direction getDirection() {
        return Direction.W;
    }

    public Direction goToTheLeft() {
        return Direction.S;
    }

    public Direction goToTheRight() {
        return Direction.N;
    }
}

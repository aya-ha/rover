package com.bnp.rover.domain;

public enum Direction {
    N('N'),
    S('S'),
    E('E'),
    W('W');

    private final char direction;

    Direction(char direction) {
        this.direction = direction;
    }

    public static Direction getDirection(char direction) {
        switch (direction) {
            case 'N': return Direction.N;
            case 'S': return Direction.S;
            case 'E': return Direction.E;
            case 'W': return Direction.W;
            default:
                return null;
        }
    }
}

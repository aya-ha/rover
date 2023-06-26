package com.bnp.rover.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Grid {

    private int x;
    private int y;

    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

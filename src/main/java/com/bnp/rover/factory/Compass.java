package com.bnp.rover.factory;

import com.bnp.rover.domain.Direction;

public abstract class Compass {

    public abstract Direction getDirection();
    public abstract Direction goToTheLeft();
    public abstract Direction goToTheRight();
}

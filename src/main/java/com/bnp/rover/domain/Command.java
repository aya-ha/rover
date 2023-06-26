package com.bnp.rover.domain;

public enum Command {
    L('L'),
    R('R');

    public final char command;

    Command(char command) {
        this.command = command;
    }
}

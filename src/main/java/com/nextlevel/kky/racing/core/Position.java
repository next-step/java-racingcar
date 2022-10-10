package com.nextlevel.kky.racing.core;

public class Position {

    private int currentPosition;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public Position() {
        currentPosition = 0;
    }

    public Position(int startPosition) {
        if(startPosition < 0) {
            throw new RuntimeException("position must be positive");
        }
        currentPosition = startPosition;
    }

    public void forwardPosition() {
        currentPosition++;
    }
}

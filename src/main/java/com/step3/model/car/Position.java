package com.step3.model.car;

public class Position {
    int position;

    public Position(int position) {
        this.position = position;
    }

    public Position add(boolean isMoved) {
        if (isMoved) {
            this.position += 1;
        }
        return this;
    }

    public int getValue() {
        return position;
    }
}

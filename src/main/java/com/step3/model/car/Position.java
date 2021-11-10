package com.step3.model.car;

public class Position {
    int Position;

    public Position(int position) {
        this.Position = position;
    }

    public Position add(boolean isMoved) {
        if (isMoved) {
            this.Position += 1;
        }
        return this;
    }

    public int getPosition() {
        return Position;
    }
}

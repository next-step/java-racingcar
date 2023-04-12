package com.next.step.step3.domain;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public Position movePosition() {
        return new Position(++this.position);
    }

    public int position() {
        return position;
    }
}

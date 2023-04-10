package com.next.step.step3.domain;

public class Position {

    private static final char MOVE_MARK = '-';

    private String position;

    public Position(String position) {
        this.position = position;
    }

    public void movePosition() {
        this.position += MOVE_MARK;
    }

    public String position() {
        return position;
    }
}

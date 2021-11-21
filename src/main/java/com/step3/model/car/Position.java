package com.step3.model.car;

import java.util.Comparator;

public class Position implements Comparable<Position> {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getValue() {
        return position;
    }

    public Position add() {
        this.position += 1;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int compareTo(Position p) {
        if (this.equals(p)) {
            return 0;
        }

        if (p.position < this.position) {
            return 1;
        }

        return -1;
    }
}

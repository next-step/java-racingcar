package com.racing.domain;

import java.util.Objects;

public class Position {
    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        this.position = position;
    }

    public void addPosition() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public String displayDashAsPosition() {
        return "-".repeat(this.position);
    }

    public boolean isBiggerThanPosition(int number) {
        return this.position < number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }
}

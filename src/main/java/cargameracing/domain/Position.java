package cargameracing.domain;

import java.util.Objects;

public class Position {
    public int junjin;

    public Position() {
        this(0);
    }

    public Position(int position) {
        this.junjin = position;
    }

    public Position move() {
        this.junjin += 1;
        return this;
    }

    public int getPosition() {
        return junjin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return junjin == position.junjin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(junjin);
    }
}


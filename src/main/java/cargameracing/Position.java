package cargameracing;

import java.util.Objects;

public class Position {
    public int junjin;

    public Position() {
        new Position(0);
    }

    public Position(int position) {
        this.junjin = position;
    }

    public void move() {
        this.junjin += 1;
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


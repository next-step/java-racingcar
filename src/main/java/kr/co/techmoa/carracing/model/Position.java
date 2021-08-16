package kr.co.techmoa.carracing.model;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Position {

    private int coordinate;
    private final int addon = 1;

    public Position(final int coordinate) {
        this.coordinate = coordinate;
    }

    public Position plus() {
        this.coordinate += addon;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return coordinate == position.coordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }
}

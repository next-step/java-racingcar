package kr.co.techmoa.carracing.model;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Position {

    private int coordinate;

    public Position(final int coordinate) {
        this.coordinate = coordinate;
    }

    public Position plus(Position position) {
        this.coordinate += position.getCoordinate();
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

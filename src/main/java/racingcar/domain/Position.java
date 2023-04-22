package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private int number;

    public Position() {
        this.number = 0;
    }

    public void numberIncrease() {
        this.number++;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return getNumber() == position.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }

    @Override
    public int compareTo(Position position) {
        return Integer.compare(this.number, position.getNumber());
    }

}

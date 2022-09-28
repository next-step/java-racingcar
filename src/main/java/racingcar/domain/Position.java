package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private int value;

    public Position(int position) {
        this.value = position;
    }

    public void move(){
        this.value++;
    }

    public int showPosition(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.value, o.value);
    }
}

package domain;

import java.util.Objects;

/**
 * 위치 구현체
 */
public class Position implements Comparable<Position> {
    private int value;

    public Position(int value) {
        this.value = value;
    }

    /**
     * 위치 값 증가
     */
    public void add() {
        this.value++;
    }

    /**
     * 위치 값 출력
     */
    public String print() {
        return "-".repeat(this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Position position = (Position)o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(value, other.value);
    }
}

package racing.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Position implements Comparable<Position> {

    private static final Integer DEFAULT_POSITION = 0;

    private int value;

    public Position() {
        this.value = DEFAULT_POSITION;
    }

    public Position(int position) {
        if (position < DEFAULT_POSITION) {
            throw new RuntimeException("자동차의 위치는 0 이상이어야 합니다.");
        }
        this.value = position;
    }

    public Position move() {
        return new Position(this.value + 1);
    }

    public boolean isSameWith(Position position) {
        return new Position(this.value).equals(position);
    }

    public static Position max(List<Position> positions) {
        return positions.stream()
                .sorted()
                .collect(Collectors.toList())
                .get(positions.size() - 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Position position1 = (Position) other;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(this.value, other.value);
    }

}

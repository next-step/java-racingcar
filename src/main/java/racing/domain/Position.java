package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Position {

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

    public void move() {
        this.value++;
    }

    public boolean isSameWith(Position position) {
        return new Position(this.value).equals(position);
    }

    public static Position max(List<Position> positions) {
        return new Position(Collections.max(positions.stream()
                .map(Position::getValue)
                .collect(Collectors.toList())));
    }

    public int getValue() {
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

}

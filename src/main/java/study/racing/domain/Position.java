package study.racing.domain;

import java.util.Objects;

public class Position {

    private static final String DASH = "-";
    private static final String NEXT_LINE = "\n";
    private final int value;

    public Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getDash() {

        return DASH.repeat(value) + NEXT_LINE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

package racingcar.domain;

import java.util.Objects;

public class RacingCarPosition {
    private final int value;

    public RacingCarPosition() {
        this(0);
    }

    public RacingCarPosition(int value) {
        this.value = value;
    }

    public RacingCarPosition add() {
        return new RacingCarPosition(this.value + 1);
    }

    public int getValue() {
        return this.value;
    }

    public boolean checkPosition() {
        return value >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarPosition that = (RacingCarPosition) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

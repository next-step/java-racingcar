package racingcar.domain;

import java.util.Objects;

public class Lap {

    private static final int MIN_LAPS = 1;

    private final int value;

    private Lap(int value) {
        this.value = value;
    }

    private static void verify(int value) {
        if (value < MIN_LAPS) {
            throw new IllegalArgumentException("라운드는 최소 1이상이어야 합니다.");
        }
    }

    public static Lap from(int value) {
        verify(value);
        return new Lap(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lap lap = (Lap) o;
        return value == lap.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

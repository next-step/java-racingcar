package study.racing.domain;

import java.util.Objects;

public class Torque {
    private static final int MOVE_CONDITION = 4;
    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 0;

    private final int value;

    public Torque(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("토크 값은 0~9 사이여야 합니다.");
        }
    }

    public boolean isMovable() {
        return value >= MOVE_CONDITION;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Torque torque = (Torque) o;
        return value == torque.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Torque{value= " + value + "}";
    }
}

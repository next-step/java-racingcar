package com.nextstep.racingcar.domain.car;

import java.util.Objects;

public class MoveLength {
    private static final int MIN_VALUE = 0;
    private final int value;

    private MoveLength(int value) {
        validation(value);
        this.value = value;
    }

    public static MoveLength createZero() {
        return new MoveLength(0);
    }

    protected static MoveLength createByInt(int value) {
        return new MoveLength(value);
    }

    public int toInt() {
        return this.value;
    }

    private void validation(int value) {
        if (value < MIN_VALUE) throw new IllegalArgumentException();
    }

    public MoveLength increase() {
        return new MoveLength(this.value + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveLength that = (MoveLength) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String toStringLength() {
        String stringLength = "";
        if (this.value == MIN_VALUE) {
            return stringLength;
        }
        for (int i = 0; i < this.value; i++) {
            stringLength += "-";
        }
        return stringLength;
    }
}

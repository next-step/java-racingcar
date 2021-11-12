package com.kakao.racingcar.domain.car;

import java.util.Objects;

public class Position {
    private int value = 0;

    public int getValue() {
        return value;
    }

    public void moveOne() {
        value++;
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

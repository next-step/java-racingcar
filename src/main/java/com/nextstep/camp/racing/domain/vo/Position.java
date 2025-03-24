package com.nextstep.camp.racing.domain.vo;

import java.util.Objects;

import com.nextstep.camp.racing.common.vo.PositiveInteger;

public class Position {

    private final PositiveInteger value;

    private Position(PositiveInteger value) { this.value = value; }

    public static Position of(PositiveInteger value) {
        return new Position(value);
    }

    public PositiveInteger value() {
        return value;
    }

    public Position add(int value) {
        return new Position(this.value.add(value));
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Position position = (Position) object;
        return Objects.equals(value, position.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}

package com.nextstep.racingcar.domain.round;

import com.nextstep.racingcar.domain.car.MoveLength;

import java.util.Objects;

public class RoundResult {
    private final String driverName;
    private final MoveLength moveLength;

    private RoundResult(String driverName, MoveLength moveLength) {
        this.driverName = driverName;
        this.moveLength = moveLength;
    }

    public static RoundResult create(String driverName, MoveLength moveLength) {
        return new RoundResult(driverName, moveLength);
    }

    public String getDriverName() {
        return driverName;
    }

    public MoveLength getMoveLength() {
        return moveLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundResult that = (RoundResult) o;
        return Objects.equals(driverName, that.driverName) &&
                Objects.equals(moveLength, that.moveLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverName, moveLength);
    }
}

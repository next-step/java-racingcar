package com.nextstep.racingcar.domain.round;

import com.nextstep.racingcar.domain.car.MoveLength;

import java.util.Objects;

public class CarRoundResult {
    private final String driverName;
    private final MoveLength moveLength;

    private CarRoundResult(String driverName, MoveLength moveLength) {
        this.driverName = driverName;
        this.moveLength = moveLength;
    }

    public static CarRoundResult create(String driverName, MoveLength moveLength) {
        return new CarRoundResult(driverName, moveLength);
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
        CarRoundResult that = (CarRoundResult) o;
        return Objects.equals(driverName, that.driverName) &&
                Objects.equals(moveLength, that.moveLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverName, moveLength);
    }

    public String toStringStatus() {
        return this.driverName + " : " + this.moveLength.toStringLength();
    }
}

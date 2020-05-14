package com.nextstep.racingcar.domain.round;

import com.nextstep.racingcar.domain.car.MoveLength;

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
}

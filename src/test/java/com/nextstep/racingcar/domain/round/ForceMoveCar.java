package com.nextstep.racingcar.domain.round;

import com.nextstep.racingcar.domain.car.Car;
import com.nextstep.racingcar.domain.car.MoveLength;

public class ForceMoveCar implements Car {
    private MoveLength moveLength;

    public ForceMoveCar() {
        moveLength = MoveLength.createZero();
    }

    @Override
    public void move() {
        this.moveLength = this.moveLength.increase();
    }

    @Override
    public MoveLength getMoveLength() {
        return this.moveLength;
    }
}

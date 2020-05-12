package com.nextstep.racingcar.domain.round;

import com.nextstep.racingcar.domain.car.Car;
import com.nextstep.racingcar.domain.car.MoveLength;
import com.nextstep.racingcar.domain.car.Power;

public class ForceMoveCar implements Car {
    private MoveLength moveLength;

    public ForceMoveCar() {
        moveLength = MoveLength.createZero();
    }

    @Override
    public void move(Power power) {
        this.moveLength = this.moveLength.increase();
    }
}

package com.nextstep.camp.racing.domain.entity;

import com.nextstep.camp.racing.common.vo.PositiveInteger;
import com.nextstep.camp.racing.domain.vo.Cars;

public class Racing {

    private final Cars cars;
    private final PositiveInteger lapCount;

    private Racing(PositiveInteger carQuantity, PositiveInteger lapCount) {
        this.cars = Cars.of(carQuantity);
        this.lapCount = lapCount;
    }

    public static Racing initialize(PositiveInteger carQuantity, PositiveInteger maxPosition) {
        return new Racing(carQuantity, maxPosition);
    }

    public void start() {
        while (!isFinished()) {
            cars.move();
        }
    }

    private boolean isFinished() {
        return cars.getMaxPosition().equals(lapCount);
    }

    public Cars getCars() {
        return cars;
    }
}

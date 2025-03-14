package com.nextstep.camp.racing.domain.entity;

import com.nextstep.camp.racing.common.vo.PositiveInteger;
import com.nextstep.camp.racing.domain.vo.Cars;
import com.nextstep.camp.racing.domain.vo.Position;

public class Racing {

    private final Cars cars;
    private final Position maxPosition;

    private Racing(PositiveInteger carQuantity, PositiveInteger maxPosition) {
        this.cars = Cars.of(carQuantity);
        this.maxPosition = Position.of(maxPosition);
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
        return cars.getMaxPosition().compareTo(maxPosition) == 0;
    }

    public Cars getCars() {
        return cars;
    }
}

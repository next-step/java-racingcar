package com.nextstep.racingcar.domain.round;

import com.nextstep.racingcar.domain.car.Cars;
import com.nextstep.racingcar.domain.car.MoveLength;

import java.util.List;

public class Round {
    private Cars cars;

    private Round(Cars cars) {
        this.cars = cars;
    }

    public static Round newRound(Cars cars) {
        return new Round(cars);
    }

    public int getCarNumber() {
        return this.cars.size();
    }

    public void moveAll() {
        this.cars.moveAll();
    }

    public List<MoveLength> getResult() {
        return this.cars.getMoveLengths();
    }
}

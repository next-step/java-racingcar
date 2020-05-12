package com.nextstep.racingcar.domain.round;

import com.nextstep.racingcar.domain.car.Car;
import com.nextstep.racingcar.domain.car.Power;

import java.util.List;

public class Round {
    private List<Car> cars;

    private Round(List<Car> cars) {
        this.cars = cars;
    }

    public static Round newRound(List<Car> cars) {
        return new Round(cars);
    }

    public int getCarNumber() {
        return this.cars.size();
    }

    public void moveAll() {
        this.cars.forEach(car -> car.move(Power.generate()));
    }
}

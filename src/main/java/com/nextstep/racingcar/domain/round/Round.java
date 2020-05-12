package com.nextstep.racingcar.domain.round;

import com.nextstep.racingcar.domain.car.Car;

import java.util.List;
import java.util.stream.Collectors;

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
        this.cars.forEach(Car::move);
    }

    public List<Integer> getResult() {
        return cars.stream()
                .map(car -> car.getMoveLength().toInt())
                .collect(Collectors.toList());
    }
}

package com.nextstep.racingcar.domain.round;

import com.nextstep.racingcar.domain.car.Car;
import com.nextstep.racingcar.domain.car.Power;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Round {
    private List<Car> cars = new ArrayList<>();

    private Round(int numberOfCar) {
        IntStream.range(0, numberOfCar).forEach(number -> {
            cars.add(new Car());
        });
    }

    public static Round newRound(int numberOfCar) {
        return new Round(numberOfCar);
    }

    public int getCarNumber() {
        return this.cars.size();
    }

    public void moveAll() {
        this.cars.forEach(car -> car.move(Power.generate()));
    }
}

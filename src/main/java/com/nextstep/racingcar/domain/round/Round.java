package com.nextstep.racingcar.domain.round;

import com.nextstep.racingcar.domain.car.RandomMoveCar;
import com.nextstep.racingcar.domain.car.Power;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Round {
    private List<RandomMoveCar> randomMoveCars = new ArrayList<>();

    private Round(int numberOfCar) {
        IntStream.range(0, numberOfCar).forEach(number -> {
            randomMoveCars.add(new RandomMoveCar());
        });
    }

    public static Round newRound(int numberOfCar) {
        return new Round(numberOfCar);
    }

    public int getCarNumber() {
        return this.randomMoveCars.size();
    }

    public void moveAll() {
        this.randomMoveCars.forEach(randomMoveCar -> randomMoveCar.move(Power.generate()));
    }
}

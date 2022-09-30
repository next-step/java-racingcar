package com.nextstep.javaRacing.racing.race;

import com.nextstep.javaRacing.racing.car.Car;
import com.nextstep.javaRacing.racing.car.RandomMoveStrategy;
import com.nextstep.javaRacing.racing.view.InputView;

import java.util.LinkedList;
import java.util.List;

public class RaceFactory {

    private static final String DEFAULT_CAR_NAME_PREFIX = "raceCar_";

    public static Race prepareRace(int cars, int turns) {
        List<Car> raceCars = new LinkedList<>();
        for (int i = 0; i < cars; i++) {
            Car car = new Car(DEFAULT_CAR_NAME_PREFIX + i, new RandomMoveStrategy());
            raceCars.add(car);
        }
        return new Race(raceCars, turns);
    }
}

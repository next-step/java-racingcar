package com.nextstep.javaRacing.racing.race;

import com.nextstep.javaRacing.racing.car.Car;
import com.nextstep.javaRacing.racing.car.MoveStrategy;
import com.nextstep.javaRacing.racing.car.RandomMoveStrategy;
import com.nextstep.javaRacing.racing.view.InputView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RaceFactory {

    private static final String DEFAULT_CAR_NAME_PREFIX = "car_";
    private static final MoveStrategy DEFAULT_MOVE_STRATEGY = new RandomMoveStrategy();

    public static Race prepareRace(int cars, int turns) {
        List<Car> raceCars = new ArrayList<>();
        for (int i = 0; i < cars; i++) {
            Car car = new Car(DEFAULT_CAR_NAME_PREFIX + i, DEFAULT_MOVE_STRATEGY);
            raceCars.add(car);
        }
        return new Race(raceCars, turns);
    }

    public static Race prepareRace(String carNames, int turns) {
        String[] splitCarNames = carNames.split(",");
        List<Car> raceCars = new ArrayList<>();
        for (String carName : splitCarNames) {
            Car car = new Car(carName, DEFAULT_MOVE_STRATEGY);
            raceCars.add(car);
        }
        return new Race(raceCars, turns);
    }
}

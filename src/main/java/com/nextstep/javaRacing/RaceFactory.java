package com.nextstep.javaRacing;

import com.nextstep.javaRacing.view.InputView;

import java.util.LinkedList;
import java.util.List;

public class RaceFactory {

    public static Race prepareRace(InputView inputView) {
        return prepareRace(inputView.cars(), inputView.turns());
    }

    public static Race prepareRace(int cars, int turns) {
        List<Car> raceCars = new LinkedList<>();
        for (int i = 0; i < cars; i++) {
            Car car = new RaceCar("raceCar_" + i, new RandomMoveStrategy());
            raceCars.add(car);
        }
        return new Race(raceCars, turns);
    }
}

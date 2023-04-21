package study.racingcar.domain;

import study.racingcar.strategy.CarMoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SettingGame {

    private static final int ZERO = 0;
    public static List<Car> createCars(RacingGameInputs racingGameInputs) {

        List<Car> carList = new ArrayList<>();

        CarMoveStrategy carMoveStrategy = new CarMoveStrategy(new Random());

        for (int i = 0; i < racingGameInputs.getNameOfCars().size(); i++) {
            carList.add(new Car(ZERO, racingGameInputs.getNameOfCars().get(i), carMoveStrategy));
        }

        return carList;
    }
}

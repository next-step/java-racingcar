package study.racingcar.domain;

import study.racingcar.strategy.CarMoveStrategy;
import study.racingcar.util.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class SettingGame {

    private static final int ZERO = 0;
    public static List<Car> createCars(RacingGameInputs racingGameInputs) {

        List<Car> carList = new ArrayList<>();

        CarMoveStrategy carMoveStrategy = new CarMoveStrategy(new RandomNumber());

        for (int i = 0; i < racingGameInputs.getNameOfCars().size(); i++) {
            carList.add(new Car(ZERO, racingGameInputs.getNameOfCars().get(i), carMoveStrategy));
        }

        return carList;
    }
}

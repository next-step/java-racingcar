package study.racingcar;

import java.util.ArrayList;
import java.util.List;

public class SettingGame {

    private static int ZERO = 0;
    public static List<Car> createCars(RacingGameInputs racingGameInputs) {

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < racingGameInputs.getNameOfCars().length; i++) {
            carList.add(new Car(ZERO, racingGameInputs.getNameOfCars()[i]));
        }

        return carList;
    }
}

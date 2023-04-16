package study.racingcar;

import java.util.ArrayList;
import java.util.List;

public class SettingGame {

    private static int ZERO = 0;
    public static List<Car> createCars(InputValue inputValue) {

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < inputValue.getNameOfCars().length; i++) {
            carList.add(new Car(ZERO, inputValue.getNameOfCars()[i]));
        }

        return carList;
    }
}

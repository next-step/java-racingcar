package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private Cars() {

    }

    public static List<Car> createCars(String[] carNames) {
        List<Car> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new Car(carName));
        }
        return racingCars;
    }


}

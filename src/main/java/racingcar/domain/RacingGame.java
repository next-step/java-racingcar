package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final List<Car> carList = new ArrayList<>();

    public List<Car> createCar(int number) {
        for (int i = 0; i < number; i++) {
            carList.add(new Car());
        }
        return carList;
    }

}

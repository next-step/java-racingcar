package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public static List<Car> ready(int numberOfCar) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            carList.add(new Car());
        }
        return carList;
    }
}

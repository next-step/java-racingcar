package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class CarsFactory {

    public static final String DELIMITER = ",";

    public static Cars newInstance(String carNames) {
        return new Cars(toCarList(carNames));
    }

    private static List<Car> toCarList(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : split(carNames)) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static String[] split(String carNames) {
        return carNames.split(DELIMITER);
    }
}

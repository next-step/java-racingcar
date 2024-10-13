package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private static final String DELIMITER = ",";

    public static List<Car> createCars(String names) {
        List<Car> cars = new ArrayList<>();

        for (String name: names.split(DELIMITER)) {
                cars.add(new Car(name));
        }

        return cars;
    }
}

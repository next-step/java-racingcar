package pobiRacingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static final String CAR_NAMES_DELIMITER = ",";

    public static List<Car> create(String carNames) {
        String[] names = carNames.split(CAR_NAMES_DELIMITER);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}

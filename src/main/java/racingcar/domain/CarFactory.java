package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    private final List<Car> cars;

    private static final String DELIMITER = ",";

    public CarFactory(String names) {
        cars = new ArrayList<>();
        createCars(parseNames(names));
    }

    private static String[] parseNames(String names) {
        return names.split(DELIMITER);
    }

    public List<Car> createCars(String[] names) {
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}

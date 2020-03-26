package util;

import domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarFactory {

    private static final String NAME_DELIMITER = ",";

    public static List<Car> createCars(String names) {
        List<Car> cars = new ArrayList<>();
        for (String name : Arrays.asList(names.split(NAME_DELIMITER))) {
            cars.add(new Car(name));
        }
        return cars;
    }
}

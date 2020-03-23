package util;

import domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }
}

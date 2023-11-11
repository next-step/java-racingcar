package step4.helper;

import step4.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static List<Car> createCars(String nameStr) {
        String[] names = nameStr.split(",");



        List<Car> cars = new ArrayList<>(names.length);
        for (String name : names) {
            validateName(name);
            cars.add(new Car(name));
        }

        return cars;
    }

    private static void validateName(String name) {

    }
}

package step4.helper;

import step4.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    private CarFactory() {}

    public static List<Car> createCars(String nameStr) {
        String[] names = nameStr.split(",");
        List<Car> cars = new ArrayList<>(names.length);
        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }
}

package step3.helper;

import step3.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static List<Car> createCars(int size) {
        List<Car> cars = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}

package racing.generator;

import racing.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class CarsGenerator {
    public static List<Car> generateCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
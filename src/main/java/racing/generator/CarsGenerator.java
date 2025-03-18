package racing.generator;

import racing.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class CarsGenerator {
    public static List<Car> generateCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }
}
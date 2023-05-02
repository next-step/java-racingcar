package car_racing;

import util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> generateCars(List<String> carNames, NumberGenerator numberGenerator) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, numberGenerator));
        }
        return cars;
    }
}

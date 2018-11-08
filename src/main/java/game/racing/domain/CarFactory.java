package game.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> createDefaultShapeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public static List<Car> createCustomShapeCars(String[] carNames, String carShape) {
        List<Car> cars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            cars.add(new Car(carName, carShape));
        }
        return cars;
    }

}

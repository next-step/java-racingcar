package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static List<Car> initCars(String[] carsName) {
        List<Car> cars = new ArrayList<>();
        for(String name : carsName) {
            cars.add(new Car(name));
        }
        return cars;
    }
}

package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static Cars initCars(String carsName) {
        String[] carsArray = carsName.split(",");
        List<Car> cars = new ArrayList<>();
        for(String name : carsArray) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }
}

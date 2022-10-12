package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarUtil {

    public static List<Car> initCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}

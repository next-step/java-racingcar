package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> create(String[] names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(create(name));
        }

        return cars;
    }

    public static Car create(String name) {
        return new Car(name);
    }
}

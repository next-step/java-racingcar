package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static Cars create(String names) {
        List<Car> cars = new ArrayList<>();
        String[] namesArray = names.split(",");

        for (String name : namesArray) {
            cars.add(new Car(name));
        }

        return new Cars(cars);
    }
}

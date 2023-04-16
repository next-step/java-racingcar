package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static List<Car> create(String names) {
        List<Car> cars = new ArrayList<>();
        String[] namesArray = names.split(",");
        for (String name : namesArray) {
            cars.add(new Car(name));
        }
        return cars;
    }
}

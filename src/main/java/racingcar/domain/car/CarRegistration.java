package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public class CarRegistration {

    private static List<Car> cars;

    public static List<Car> register(String[] racers) {
        cars = new ArrayList<Car>();

        for (String racer : racers) {
            cars.add(new Car(racer));
        }

        return cars;
    }

    public static List<Car> getCars() {
        return cars;
    }
}

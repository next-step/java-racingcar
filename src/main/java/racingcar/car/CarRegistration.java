package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class CarRegistration {

    public static List<Car> register(String[] racers) {
        List<Car> cars = new ArrayList<Car>();

        for (String racer : racers) {
            cars.add(new Car(racer, 0));
        }

        return cars;
    }
}

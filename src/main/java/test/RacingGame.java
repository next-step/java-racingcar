package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private void moveCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1));
        cars.add(new Car(1));

        for (Car car : cars) {
            car.move(new RandomValueMovingStrategy());
        }
    }
}

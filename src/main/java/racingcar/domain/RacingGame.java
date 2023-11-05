package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public List<Car> generateCars (int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public List<Car> race() {
        moveCars();
        return cars;
    }
    private void moveCars() {
        for (Car car : cars) {
            car.move(getRandomNumber());
        }
    }

    private int getRandomNumber() {
        return new Random().nextInt(10);
    }
}

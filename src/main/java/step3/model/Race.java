package step3.model;

import java.util.List;
import java.util.Random;

public class Race {

    private static final Random random = new Random();
    private static final int MAX_RANDOM_VALUE = 10;
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void playing(int randomValue) {
        if (new Car().isMovable(randomValue)) {
            cars.forEach(Car::go);
        }
    }

    public static int getRandomValue() {
        return random.nextInt(MAX_RANDOM_VALUE);
    }
}


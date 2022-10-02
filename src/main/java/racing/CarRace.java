package racing;

import java.util.List;
import java.util.Random;

public class CarRace {
    public static final int RANDOM_BOUND = 10;
    public static final int MOVE_THRESHOLD = 4;
    private Random randomGenerator;
    private List<Car> cars;

    public CarRace(List<Car> cars, Random randomGenerator) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("car is empty");
        }
        this.cars = cars;
        this.randomGenerator = randomGenerator;
    }

    public CarRace(List<Car> cars) {
        this(cars, new Random());
    }

    public void race() {
        cars.forEach(this::race);
    }

    private void race(Car car) {
        if (shouldMove()) {
            car.move();
        }
    }

    private boolean shouldMove() {
        return randomGenerator.nextInt(RANDOM_BOUND) >= MOVE_THRESHOLD;
    }
}

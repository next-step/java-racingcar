package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final static int MAX_BOUND = 10;
    private final static int MOVABLE_THRESHOLD = 4;

    private final List<Car> cars;
    private final Random random;

    public RacingGame() {
        this.cars = new ArrayList<>();
        this.random = new Random();
    }

    public void createCars(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }

    public void tryGame() {
        for (Car car : cars) {
            if (isMovable()) {
                car.forward();
            }
        }
    }

    protected boolean isMovable() {
        return random.nextInt(MAX_BOUND) >= MOVABLE_THRESHOLD;
    }

    public List<Car> getCars() {
        return cars;
    }
}

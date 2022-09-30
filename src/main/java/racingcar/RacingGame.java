package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final static int MAX_BOUND = 10;
    private final static int MOVABLE_THRESHOLD = 4;
    private List<Car> cars = new ArrayList<>();

    public void createCars(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }
    public void tryGame() {
        Random random = new Random();

        for (Car car : cars) {
            if (isMovable(random)) {
                car.forward();
            }
        }
    }

    private boolean isMovable(Random random) {
        return random.nextInt(MAX_BOUND) >= MOVABLE_THRESHOLD;
    }

    public List<Car> getCars() {
        return cars;
    }
}

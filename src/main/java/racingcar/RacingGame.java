package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int MAX_RANDOM_BOUND = 10;

    private int tryCount;
    private List<Car> cars = new ArrayList<>();

    public RacingGame(int numberOfCars, int tryCount) {
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        this.tryCount = tryCount;
    }

    public void run() {
        for (int i = 0; i < tryCount; i++) {
            moveAll();
        }
    }

    public List<Car> getResult() {
        return cars;
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_BOUND);
    }

    private void moveAll() {
        for (Car car : cars) {
            car.move(getRandom());
        }
    }

}

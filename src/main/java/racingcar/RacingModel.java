package racingcar;

import java.util.List;
import java.util.Random;

import static java.util.Random.*;

public class RacingModel {
    private int numberOfCar;
    private int tryCount;
    private static final int MOVE_POSSIBLE = 4;
    private static final int RANDOM_RANGE = 10;
    public RacingModel(int numberOfCar, int tryCount) {
        this.numberOfCar = numberOfCar;
        this.tryCount = tryCount;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }
    public int getTryCount() {
        return tryCount;
    }

    public boolean isMovePossible() {
        Random random = new Random();
        if (random.nextInt(RANDOM_RANGE) >= MOVE_POSSIBLE) {
            return true;
        }
        return false;
    }

    public void racingStart(List<Car> cars) {
        for (Car car : cars) {
            if (isMovePossible()) {
                car.move();
            }
        }
    }
}

package racingcar.race;

import racingcar.race.Car;
import racingcar.util.RandomUtil;

import java.util.List;
import java.util.Random;

import static racingcar.util.RandomUtil.*;

public class RacingModel {
    private static final int MOVE_POSSIBLE = 4;
    private static final int RANDOM_RANGE = 10;
    private int numberOfCar;
    private int tryCount;

    public RacingModel(int numberOfCar, int tryCount) {
        this.numberOfCar = numberOfCar;
        this.tryCount = tryCount;
    }

    public void racingStart(List<Car> cars) {
        for (Car car : cars) {
            if (isMovePossible(generateMovePossibleNumber())) {
                car.move();
            }
        }
    }
    public static boolean isMovePossible(int number) {
        if (number >= MOVE_POSSIBLE) {
            return true;
        }
        return false;
    }


    public int getNumberOfCar() {
        return numberOfCar;
    }
    public int getTryCount() {
        return tryCount;
    }
}

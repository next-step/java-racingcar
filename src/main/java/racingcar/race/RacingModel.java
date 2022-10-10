package racingcar.race;

import static racingcar.util.RandomUtil.generateMovePossibleNumber;

public class RacingModel {
    private static final int MOVE_POSSIBLE = 4;
    private static final int RANDOM_RANGE = 10;

    private int numberOfCar;
    private int tryCount;

    public RacingModel(int numberOfCar, int tryCount) {
        if (numberOfCar < 0 || tryCount < 0) {
            throw new RuntimeException("0보다 큰 수를 입력하세요");
        }
        this.numberOfCar = numberOfCar;
        this.tryCount = tryCount;
    }

    public void racingStart(RacingCars racingCars) {
        for (Car car : racingCars.getRacingCars()) {
            car.move(generateMovePossibleNumber());
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

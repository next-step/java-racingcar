package racingcar;

import java.util.Random;

public class RacingGame {

    public static final int UPPER_BOUND = 10;
    private int currentRoundCount = 0;
    private Car[] cars;

    public RacingGame(Car[] cars) {
        this.cars = cars;
    }

    public int getNumberOfCars() {
        return cars.length;
    }

    public int getCurrentRoundCount() {
        return currentRoundCount;
    }

    public void runSingleRound() {
        Random random = new Random();

        for (Car car : cars) {
            car.moveForwardOrStop(random.nextInt(UPPER_BOUND));
        }

        currentRoundCount++;
    }


}

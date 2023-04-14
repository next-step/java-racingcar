package racingcar;

import java.util.Random;

public class RacingGame {

    private final int numberOfRounds;
    private int currentRoundCount = 0;
    private Car[] cars;

    public RacingGame(int numberOfRounds, Car[] cars) {
        this.numberOfRounds = numberOfRounds;
        this.cars = cars;
    }

    public int getNumberOfCars() {
        return cars.length;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getCurrentRoundCount() {
        return currentRoundCount;
    }

    public void runSingleRound() {
        Random random = new Random();

        for (Car car : cars) {
            car.moveForwardOrStop(random.nextInt(10));
        }

        currentRoundCount++;
    }


}

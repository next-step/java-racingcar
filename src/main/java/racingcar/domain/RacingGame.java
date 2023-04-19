package racingcar.domain;

import java.util.Arrays;
import java.util.Random;

public class RacingGame {

    public static final int UPPER_BOUND = 10;
    private int currentRoundCount = 0;
    private final Car[] cars;
    private static Random random = new Random();

    public RacingGame(Car[] cars) {
        this.cars = cars;
    }

    public int getCurrentRoundCount() {
        return currentRoundCount;
    }

    public void runSingleRound() {
        for (Car car : cars) {
            car.moveForwardOrStop(random.nextInt(UPPER_BOUND));
        }

        currentRoundCount++;
    }

    public String[] getWinners() {
        int maxDistance = Arrays.stream(cars).mapToInt(car -> car.getDistance()).max().orElse(0);

        return Arrays.stream(cars).filter(car -> car.getDistance() == maxDistance).map(Car::getName).toArray(String[]::new);
    }
}

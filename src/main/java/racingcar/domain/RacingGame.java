package racingcar.domain;

import java.util.Arrays;

public class RacingGame {

    private final Car[] cars;
    private RandomNumber randomNumber;

    public RacingGame(Car[] cars, RandomNumber randomNumber) {
        this.cars = cars;
        this.randomNumber = randomNumber;
    }

    public void runSingleRound() {
        for (Car car : cars) {
            car.moveForwardOrStop(randomNumber.getInt());
        }
    }

    public String[] getWinners() {
        int maxDistance = Arrays.stream(cars).mapToInt(car -> car.getDistance()).max().orElse(0);

        return Arrays.stream(cars).filter(car -> car.equalsDistance(maxDistance)).map(Car::getName).toArray(String[]::new);
    }
}

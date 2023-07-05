package racingcar;

import java.util.Arrays;

public class RacingGame {
    public final RacingCar[] cars;
    public final int count;

    public RacingGame(RacingCar[] cars, int count) {
        this.cars = cars;
        this.count = count;
    }

    public RacingCar[] selectWinners() {
        int winnerCount = Arrays.stream(cars)
                .mapToInt(car -> car.moveCount)
                .max()
                .orElse(0);

        return Arrays.stream(cars)
                .filter(car -> car.moveCount == winnerCount)
                .toArray(RacingCar[]::new);
    }
}

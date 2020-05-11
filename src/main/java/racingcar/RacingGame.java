package racingcar;

import racingcar.view.ResultView;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RacingGame {

    private static final int MINIMUM_CAR_COUNT = 2;
    private static final int MINIMUM_ROUND = 1;

    private int round;
    private Car[] cars;

    public RacingGame(int round, int carCount) {

        validate(round, carCount);

        this.round = round;
        this.cars = generateCars(carCount);
    }

    private Car[] generateCars(int carCount) {
        Car[] cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = Car.newInstance();
        }
        return cars;
    }

    public int[] play() {
        IntStream.range(0, round)
                .mapToObj(value -> moveAll())
                .forEach(ResultView::printCarPositionPerRound);

        return Arrays.stream(cars)
                .mapToInt(Car::getPosition)
                .toArray();
    };

    private int[] moveAll() {
      return Arrays.stream(cars)
                .mapToInt(Car::move)
                .toArray();
    }

    private static void validate(int round, int carCount) {
        if (round < MINIMUM_ROUND || carCount < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
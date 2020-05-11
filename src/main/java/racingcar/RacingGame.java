package racingcar;

import racingcar.view.ResultView;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RacingGame {

    private int round;
    private Car[] cars;

    public RacingGame(int round, int carCount) {
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
}
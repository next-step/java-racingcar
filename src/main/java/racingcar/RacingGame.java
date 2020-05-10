package racingcar;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RacingGame {
    private int round;
    private Car[] cars;

    public RacingGame(int round, Car[] cars){
        this.round = round;
        this.cars = cars;
    }

    public int[] play() {
        IntStream.range(0, round)
                .forEach(value -> moveAll());

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
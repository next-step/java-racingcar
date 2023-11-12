package racingcar.application;

import racingcar.domain.Car;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RaceService {
    private static final Random random = new Random();

    public static List<Car> startRace(List<Car> cars, int tryCount) {
        IntStream.range(0, tryCount)
                 .forEach(i -> race(cars));
        return cars;
    }

    private static void race(List<Car> cars) {
        for (Car car : cars) {
            car.moveForwardByCondition(random.nextInt(10));
        }
    }
}

package racingcar.application;

import racingcar.domain.Car;
import racingcar.util.RandomUtils;

import java.util.List;
import java.util.stream.IntStream;

public class RaceService {

    public static List<Car> startRace(List<Car> cars, int tryCount) {
        IntStream.range(0, tryCount)
                 .forEach(i -> race(cars));
        return cars;
    }

    private static void race(List<Car> cars) {
        for (Car car : cars) {
            int randomInt = RandomUtils.getRandomInt(10);
            car.moveForwardByCondition(randomInt);
        }
    }
}

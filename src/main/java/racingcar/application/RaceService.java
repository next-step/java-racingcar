package racingcar.application;

import racingcar.domain.Car;
import racingcar.util.RandomUtils;
import racingcar.view.ResultView;

import java.util.List;
import java.util.stream.IntStream;

public class RaceService {
    public static List<Car> startRace(int carCount, int round) {
        System.out.println("실행 결과");
        List<Car> cars = Car.makeCarsBy(carCount);
        IntStream.range(0, round)
                 .forEach(i -> race(cars));
        return cars;
    }

    private static void race(List<Car> cars) {
        for (Car car : cars) {
            ResultView.displayRace(car);
            int randomInt = RandomUtils.getRandomInt(10);
            car.moveForwardByCondition(randomInt);
        }
        System.out.println();
    }
}

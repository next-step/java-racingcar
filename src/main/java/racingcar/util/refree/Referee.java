package racingcar.util.refree;

import racingcar.model.Car;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class Referee {

    public static String getWinnerFrom(final List<Car> cars) {
        int max = max(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == max)
                .map(Car::toString)
                .collect(joining(", "));
    }

    public static int max(final List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElse(1);
    }


}

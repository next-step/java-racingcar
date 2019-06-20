package racingcar.model;

import static java.util.stream.Collectors.joining;

public class Referee {

    public static String getWinnerFrom(final Cars cars) {
        int max = max(cars);
        return cars.getCars()
                .stream()
                .filter(car -> car.getPosition() == max)
                .map(Car::toString)
                .collect(joining(", "));
    }

    public static int max(final Cars cars) {
        return cars.getCars()
                .stream()
                .mapToInt(Car::getPosition)
                .max().orElse(1);
    }


}

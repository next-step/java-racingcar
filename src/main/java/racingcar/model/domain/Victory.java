package racingcar.model.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.entity.Car;

public class Victory {

    private List<Car> victory;

    private Victory(final List<Car> cars) {
        victory = cars;
    }

    public List<Car> victory() {
        return Collections.unmodifiableList(victory);
    }

    public static Victory maxCheck(final List<Car> cars) {

        int max = maxDriveLength(cars);
        return new Victory(cars.stream()
            .filter(car -> isMax(max, car))
            .collect(Collectors.toList()));
    }

    private static boolean isMax(final int max, final Car car) {
        return car.getStep() == max;
    }

    private static int maxDriveLength(final List<Car> cars) {
        return cars.stream().map(car -> car.getStep())
            .mapToInt(length -> Integer.valueOf(length))
            .max()
            .getAsInt();
    }

}

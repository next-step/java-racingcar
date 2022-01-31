package racingcar.model.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.vo.Car;

public class Victory {

    private List<Car> victory;
    private static final String MAX_DRIVE_LENGTH = "MAX 값을 구할 수 없습니다. 비교할 수 있는 정수값인지 확인하세요";

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
        return cars.stream().map(Car::getStep)
            .mapToInt(Integer::valueOf)
            .max()
            .orElseThrow(()->new IllegalArgumentException(MAX_DRIVE_LENGTH));
    }

}

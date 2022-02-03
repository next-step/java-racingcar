package racingcar.model.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Victory {

    private static final String MAX_DRIVE_LENGTH = "MAX 값을 구할 수 없습니다. 비교할 수 있는 정수값인지 확인하세요";
    private List<Car> victories;

    private Victory(final List<Car> cars) {
        victories = cars;
    }

    public static Victory maxCheck(final List<Car> cars) {

        int max = maxDriveLength(cars);
        return new Victory(cars.stream()
            .filter(car -> car.isMax(max, car))
            .collect(Collectors.toList()));
    }

    private static int maxDriveLength(final List<Car> cars) {
        return cars.stream().map(Car::getStep)
            .mapToInt(Integer::valueOf)
            .max()
            .orElseThrow(() -> new IllegalArgumentException(MAX_DRIVE_LENGTH));
    }

    public List<Car> victory() {
        return Collections.unmodifiableList(victories);
    }

}

package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String DELIMITER = ",";
    private static final int MIN_SIZE = 2;

    private final List<Car> cars;

    public Cars(final String names) {
        this(names.split(DELIMITER));
    }

    public Cars(final String[] names) {
        this(Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void move(final MoveStrategy strategy) {
        cars.forEach(car -> car.move(strategy));
    }

    public List<Car> winners() {
        final Car fastestCar = cars.stream()
                .max(Car::getPositionDifferenceWith)
                .orElseThrow(() -> new IllegalStateException("[ERROR] 우승자를 찾을 수 없습니다."));

        return cars.stream()
                .filter(car -> car.isSamePositionWith(fastestCar))
                .collect(Collectors.toList());
    }

    public boolean canStartRace() {
        return cars.size() > MIN_SIZE;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}

package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String DELIMITER = ",";
    private static final int MIN_SIZE = 2;

    private final List<Car> cars;

    public Cars(String names) {
        this(names.split(DELIMITER));
    }

    public Cars(String[] names) {
        this(Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public Cars(List<Car> cars) {
        if (cars.size() < MIN_SIZE) {
            throw new IllegalArgumentException("[ERROR] 최소 2대 이상의 자동차가 있어야 합니다.");
        }

        this.cars = cars;
    }

    public void move(MoveStrategy strategy) {
        cars.forEach(car -> car.move(strategy));
    }

    public List<Car> winners() {
        Car fastestCar = cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalStateException("[ERROR] 우승자를 찾을 수 없습니다."));

        return cars.stream()
                .filter(car -> car.isSamePositionWith(fastestCar))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}

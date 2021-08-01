package racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private static final String DELIMITER = ",";
    private final List<Car> cars;

    public Cars(String carNames) {
        checkNullOrEmpty(carNames);
        this.cars = initCars(carNames.split(DELIMITER));
    }

    private void checkNullOrEmpty(String carNames) {
        if (Objects.isNull(carNames) || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("carNames는 null이거나 empty일 수 없습니다.");
        }
    }

    private List<Car> initCars(String[] carNames) {
        return Stream.of(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars(MovableStrategy movableStrategy) {
        cars.stream().forEach(car -> car.move(movableStrategy));
    }

    public List<Car> getCars() {
        return cars;
    }
}

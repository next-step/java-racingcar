package racing.domain;

import racing.domain.strategies.CarMoveStrategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private static final String EMPTY_CARS_MESSAGE = "빈 자동차들 생성불가";
    private final List<Car> cars;

    public Cars(List<String> nameOfCars) {
        if (nameOfCars == null || nameOfCars.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CARS_MESSAGE);
        }
        cars = nameOfCars.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void run(CarMoveStrategy moveStrategy) {
        Objects.requireNonNull(moveStrategy);
        cars.forEach(car -> car.run(moveStrategy));
    }

    public List<Car> getCarsEqualsPosition(Position position) {
        Objects.requireNonNull(position);
        return cars.stream()
                .filter(car -> car.getPosition().equals(position))
                .collect(Collectors.toList());
    }

    public Position getMaxPosition() {
        cars.sort(Car::compareTo);
        return Collections.max(cars, Comparator.comparing(Car::getPosition)).getPosition();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}

package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validate(List<Car> cars) {
        Objects.requireNonNull(cars, "전달된 리스트가 올바르지 않습니다 : Cars is null");

        if (cars.isEmpty()) {
            throw new IllegalArgumentException("전달된 리스트가 올바르지 않습니다 : Cars is empty");
        }
    }

    public Cars play(MovingStrategy movingStrategy) {
        return cars.stream()
                .map(car -> car.move(movingStrategy))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Cars::new));
    }

    public List<CarName> names() {
        return cars.stream()
                .map(Car::name)
                .collect(Collectors.toList());
    }

    public List<Distance> states() {
        return cars.stream()
                .map(Car::state)
                .collect(Collectors.toList());
    }

    public List<CarName> findWinnerCarNames() {
        final int maxState = getMaxState();

        return cars.stream()
                .filter(car -> car.isMaxState(maxState))
                .map(Car::name)
                .collect(Collectors.toList());
    }

    private int getMaxState() {
        return cars.stream()
                .mapToInt(car -> car.state().value())
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}

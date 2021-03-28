package racingcar.domain;

import racingcar.strategy.MoveStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static racingcar.exception.Message.EMPTY_CARS_ERROR;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateInput(cars);
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars createByNames(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public Cars runRound(MoveStrategy strategy) {
        List<Car> racingCars = cars.stream()
                .map(car -> car.move(strategy))
                .collect(Collectors.toList());
        return new Cars(racingCars);
    }

    private void validateInput(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CARS_ERROR);
        }
    }

    public List<Car> getCarsAtRound() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}

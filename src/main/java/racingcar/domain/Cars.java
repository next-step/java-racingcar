package racingcar.domain;

import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static racingcar.exception.Message.BAD_CARS_INPUT;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateInput(cars);
        this.cars = cars;
    }

    public Cars runRound(MoveStrategy strategy) {
        List<Car> racingCars = new ArrayList<>();
        for (Car car : cars) {
            racingCars.add(car.move(strategy));
        }
        return new Cars(racingCars);
    }

    private void validateInput(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(BAD_CARS_INPUT);
        }
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
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

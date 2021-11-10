package step4.domain;

import step4.strategy.MoveStrategy;
import step4.service.dto.Winners;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(List<Car> cars) {
        return new Cars(cars);
    }

    public Cars move(MoveStrategy moveStrategy) {
        List<Car> moveCars = cars.stream().map(car -> car.moveOrStop(moveStrategy))
                .collect(Collectors.toList());

        return create(moveCars);
    }

    public List<Car> getCars() {
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

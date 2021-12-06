package newRacingCar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        return cars.stream()
                .filter(car -> car.getPosition().isSamePosition(maxPositionCar()))
                .collect(Collectors.toList());
    }

    public Position maxPositionCar() {
        Position maxPosition = new Position(0);
        for (Car car : cars) {
            maxPosition = maxPosition.findMaxPosition(car.getPosition());
        }
        return maxPosition;
    }

    public List<Car> move(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
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
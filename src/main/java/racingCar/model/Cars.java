package racingCar.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> move(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
        return cars;
    }

    public List<Car> findWinners() {
        return findWinners(cars, findMaxPosition());
    }

    public static List<Car> findWinners(List<Car> cars, Position maxPosition) {
        return cars.stream()
                .filter(car -> car.samePosition(maxPosition))
                .collect(Collectors.toList());
    }

    public Position findMaxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
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

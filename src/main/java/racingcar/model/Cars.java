package racingcar.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        this.cars.forEach(Car::move);
    }

    public List<String> getStatus() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
    }

    public Cars findWinners() {
        int maxPosition = getMaxPosition();

        return getMatchPositionCars(maxPosition);
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Position.DEFAULT);
    }

    private Cars getMatchPositionCars(int position) {
        List<Car> collect = cars.stream()
                .filter(car -> car.matchPosition(position))
                .collect(Collectors.toList());

        return new Cars(collect);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public String toString() {
        return this.cars.stream()
                .map(Car::toName)
                .collect(Collectors.joining(", "));
    }

}

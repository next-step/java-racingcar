package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Cars implements Iterable<Car> {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public Cars winners() {
        Position longest = getLongestPosition();
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            addIfLongestPosition(car, longest, result);
        }
        return new Cars(result);
    }

    private void addIfLongestPosition(Car car, Position longest, List<Car> result) {
        if (longest.equals(car.position())) {
            result.add(car);
        }
    }

    private Position getLongestPosition() {
        Position position = new Position();
        for (Car car : cars) {
            position = getLongestPosition(car, position);
        }
        return position;
    }

    private Position getLongestPosition(Car car, Position position) {
        if (position.longestThen(car.position())) {
            return position;
        }
        return new Position(car.position().getValue());
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

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}

package racinggame.model;

import java.util.*;
import java.util.stream.Collectors;

public final class Cars {
    private final List<Car> cars;

    public Cars(final String[] names) {
        this(Arrays.stream(names).map(Car::new).collect(Collectors.toList()));
    }

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        this.cars.forEach(Car::moveForward);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    // 위너 찾기
    public Cars getWinners() {
        Position maxPosition = getMaxPositions();
        return new Cars(this.cars.stream().filter((car) -> car.isWinner(maxPosition)).collect(Collectors.toList()));
    }

    public Position getMaxPositions() {
        return Collections.max(cars).getPosition();
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
    public String toString() {
        return "Cars{" + "cars=" + cars + '}';
    }
}

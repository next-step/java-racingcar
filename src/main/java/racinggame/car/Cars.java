package racinggame.car;

import racinggame.strategy.MovingStrategy;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars manyOf(List<Car> cars) {
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void race(MovingStrategy strategy) {
        for (Car car : cars) {
            car.race(strategy);
        }
    }

    public String getWinner() {
        return cars.stream()
                .filter(car -> car.getPosition() == getMax())
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int getMax() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}

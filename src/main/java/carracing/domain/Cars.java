package carracing.domain;

import static carracing.utils.RandomValueGenerator.generateRandom;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> cars() {
        return cars;
    }

    public void moveCars() {
        cars.stream()
            .forEach(car -> car.move(generateRandom()));
    }

    public List<Car> findWinner() {
        Position maxPosition = findMaxPosition(cars);

        return cars.stream()
            .filter(car -> car.position().equals(maxPosition))
            .collect(Collectors.toList());
    }

    private Position findMaxPosition(List<Car> cars) {
        return cars.stream()
            .map(car -> car.position())
            .reduce(Position::calBiggerPosition)
            .get();
    }

}

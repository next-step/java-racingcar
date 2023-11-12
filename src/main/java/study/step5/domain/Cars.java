package study.step5.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars winners() {
        return new Cars(cars.stream()
            .filter(car -> car.isWinner(maxPosition()))
            .collect(Collectors.toList()));
    }

    public int maxPosition() {
        return cars.stream()
            .map(Car::position)
            .mapToInt(Position::getPosition)
            .max()
            .orElseThrow(NoSuchElementException::new);
    }
}

package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> names) {
        List<Car> cars = names.stream()
                .map(name -> Car.of(0, name))
                .collect(toList());
        return new Cars(cars);
    }

    public List<Car> cars() {
        return cars;
    }

    public Cars race() {
        List<Car> nextCars = cars.stream()
                .map(car -> car.move(new RandomMovingPolicy()))
                .collect(toList());
        return new Cars(nextCars);
    }

    public List<Car> winners() {
        return findCarsByPosition(maxPosition());
    }

    private Integer maxPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::position))
                .orElseThrow(IllegalStateException::new)
                .position();
    }

    private List<Car> findCarsByPosition(Integer position) {
        return cars.stream()
                .filter(car -> Objects.equals(car.position(), position))
                .collect(toList());
    }
}

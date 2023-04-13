package game.service;

import game.domain.Car;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

public class CarRacing {

    private final List<Car> cars;

    public CarRacing(List<String> carNames) {
        this.cars = initialCars(carNames);
    }

    private List<Car> initialCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(toUnmodifiableList());
    }

    public void start() {
        cars.forEach(Car::drive);

    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> findWinners() {
        int max = cars.stream()
                .mapToInt(Car::position)
                .max()
                .orElseThrow(IllegalStateException::new);
        return cars.stream()
                .filter(car -> car.isSamePosition(max))
                .collect(toUnmodifiableList());
    }

}
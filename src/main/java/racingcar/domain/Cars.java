package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public Car findMaxPositionCar() {
        Car maxPositionCar = new Car("max", 0);
        return cars.stream()
                .reduce(maxPositionCar, Car::max);
    }

    public Cars findWinners(final Car maxPositionCar) {
        return new Cars(cars.stream()
                .filter(car -> car.isWinner(maxPositionCar))
                .collect(Collectors.toList()));
    }

    public String toStringNames() {
        return cars.stream()
                .map(Car::toStringName)
                .collect(Collectors.joining(","));
    }

    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

    public void move() {
        for (Car car : cars) {
            car.move(new RandomNumber());
        }
    }
}

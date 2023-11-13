package racingcar.domain;

import racingcar.strategy.MoveStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> carList() {
        return cars;
    }

    public List<String> maxPositionCars() {
        return cars.stream()
                .filter(car -> car.matchPosition(maxPosition()))
                .map(car -> car.carName())
                .collect(Collectors.toList());
    }

    private Position maxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Comparator.naturalOrder()).orElse(null);
    }

    public void moveCars(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.moveForward(moveStrategy));
    }
}

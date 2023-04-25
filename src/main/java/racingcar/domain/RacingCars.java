package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(MoveStrategy moveStrategy) {
        for(Car car: cars) {
            drive(car, moveStrategy);
        }
    }

    private void drive(Car car, MoveStrategy moveStrategy) {
        if (moveStrategy.goOrStop()) {
            car.drive();
        }
    }

    public List<String> getWinner() {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition()))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int maxPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get()
                .getPosition();
    }

    public List<Car> getCars() {
        return cars;
    }
}

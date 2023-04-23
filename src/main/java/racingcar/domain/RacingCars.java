package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars)
    {
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

    public List<String> getWinner()
    {
        int maxPosition = maxPosition();
        return cars.stream().filter(car -> car.isSamePosition(maxPosition)).map(Car::getName).collect(Collectors.toList());
    }

    private int maxPosition() {
        int maxPosition = 0;
        for(Car car: cars) {
            maxPosition = car.compare(maxPosition);
        }

        return maxPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}

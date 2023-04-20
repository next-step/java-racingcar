package racingcar.service;

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
        int maxDistance = maxDistance();
        return cars.stream().filter(car -> car.isWinner(maxDistance)).map(Car::getName).collect(Collectors.toList());
    }

    private int maxDistance() {
        int maxDistance = 0;
        for(Car car: cars) {
            maxDistance = car.max(maxDistance);
        }

        return maxDistance;
    }

    public List<Car> getCars() {
        return cars;
    }
}

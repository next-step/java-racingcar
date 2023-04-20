package racingcar.service;

import java.util.ArrayList;
import java.util.List;

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
        int maxDistance = 0;
        for(Car car: cars) {
            maxDistance = car.max(maxDistance);
        }

        List<String> winners = new ArrayList<>();
        for(Car car: cars) {
            if (maxDistance == car.getDistance()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }
}

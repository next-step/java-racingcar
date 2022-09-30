package racinggame.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCar {
    private List<Car> cars;

    public RacingCar(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> racing() {
        for (Car car : cars) {
            car.move(new RandomMovingStrategy());
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        return cars.stream()
                .filter(car -> car.getStatus() == findMaxDistance())
                .collect(Collectors.toList());
    }

    private int findMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getStatus)
                .max()
                .orElse(0);
    }

    public static RacingCar of(List<String> names) {
        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        return new RacingCar(cars);
    }
}

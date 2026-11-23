package racingcar.domain;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public Cars(String names) {
        this(createCars(names));
    }

    private static List<Car> createCars(String names) {
        return Arrays.stream(names.split(",", -1))
                .map(String::trim)
                .map(Car::new)
                .toList();
    }


    public void moveCars(MoveStrategy strategy) {
        for (Car car : cars) {
            car.move(strategy);
        }
    }

    public List<Car> findWinners() {
        int maxPosition = maxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private int maxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }

}

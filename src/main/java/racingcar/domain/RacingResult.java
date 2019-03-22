package racingcar.domain;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {

    private static final int EQUAL_VALUE = 0;
    private List<Car> cars;

    public RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {

        return cars.stream()
                .filter(car -> car.compareTo(getAnyFirstCar()) == EQUAL_VALUE)
                .collect(Collectors.toList());
    }

    private Car getAnyFirstCar() {

        return cars.stream()
                .max(Car::compareTo)
                .get();

    }

    public List<Car> getCars() {
        return cars;
    }
}

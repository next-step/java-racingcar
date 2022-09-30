package racingGame.domain;

import racingGame.domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
    public List<String> findCoWinner() {
        return cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return getMaxCar().getPosition();
    }

    private Car getMaxCar() {
        return Collections.max(cars);
    }

}

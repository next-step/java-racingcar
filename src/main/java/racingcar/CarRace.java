package racingcar;

import racingcar.strategy.MovableStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRace {
    private final List<Car> cars;

    public CarRace(String[] carNames, MovableStrategy movableStrategy) {
        this.cars = Arrays.stream(carNames).map(carName -> new Car(carName, movableStrategy)).collect(Collectors.toList());
    }

    public void race() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return cars;
    }
}

package racingcar;

import racingcar.strategy.MovableStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRace {
    private final List<Car> cars;

    public CarRace(String[] carNames, MovableStrategy movableStrategy) {
        this.cars = Arrays.stream(carNames).map(carName -> new Car(carName, movableStrategy)).collect(Collectors.toList());
    }

    public CarRace(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}

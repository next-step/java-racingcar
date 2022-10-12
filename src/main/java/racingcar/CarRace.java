package racingcar;

import racingcar.strategy.MovableStrategy;
import racingcar.strategy.RandomMovableStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRace {
    private final List<Car> cars;

    public CarRace(int numberOfCars, MovableStrategy movableStrategy) {
        this.cars = Stream.generate(() -> new Car("",movableStrategy))
                .limit(numberOfCars)
                .collect(Collectors.toList());
    }

    public void race() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return cars;
    }
}

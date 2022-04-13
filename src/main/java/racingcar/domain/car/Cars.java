package racingcar.domain.car;

import racingcar.domain.car.strategy.CarActionStrategyFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(Integer carCount) {
        this.cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void act() {
        for (Car car : cars) {
            car.act(CarActionStrategyFactory.resolve());
        }
    }

    public List<Integer> getCarPositions() {
        return cars.stream().map(Car::getPosition).collect(Collectors.toList());
    }
}

package racingcar;

import racingcar.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(int carCount) {
        cars = createCars(carCount);
    }

    private List<Car> createCars(int carCount) {
        final List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public List<Car> move(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
        return cars;
    }
}

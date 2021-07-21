package racinggame.car;

import racinggame.strategy.MovingStrategy;

import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars manyOf(List<Car> cars) {
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void race(MovingStrategy strategy) {
        for (Car car : cars) {
            car.race(strategy);
        }
    }
}

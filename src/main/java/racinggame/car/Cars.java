package racinggame.car;

import racinggame.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(Count count) {
        this.cars = initCars(count);
    }

    public static Cars manyOf(Count count) {
        return new Cars(count);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void race(MovingStrategy strategy) {
        for (Car car : cars) {
            car.race(strategy);
        }
    }

    private List<Car> initCars(Count count) {
        int length = count.initValue();
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(new Car());
        }

        return list;
    }
}

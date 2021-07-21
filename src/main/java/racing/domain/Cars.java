package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(Count count) {
        this.cars = initCars(count);
    }

    private List<Car> initCars(Count count) {
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < count.getCount(); i++) {
            list.add(new Car());
        }

        return list;
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

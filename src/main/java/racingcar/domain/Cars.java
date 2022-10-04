package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public Cars move(Generator generator) {
        List<Car> moveCars = new ArrayList<>();
        for (Car car : cars) {
            moveCars.add(car.move(generator));
        }
        return new Cars(moveCars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}

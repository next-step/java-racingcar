package racingcar;

import java.util.Collections;
import java.util.List;

public class Cars {
    private static List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public void move(RandomMove randomMove) {
        cars.stream()
                .filter(car -> randomMove.canMove())
                .forEach(car -> car.move());
    }

    public List<Car> getCar() {
        return cars;
    }
}


package car;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        for(Car car: cars) {
            car.move(new RandomMoveStrategy());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}

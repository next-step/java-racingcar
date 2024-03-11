package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(int size) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            this.cars.add(new Car());
        }
    }

    public List<Car> get() {
        return Collections.unmodifiableList(cars);
    }

    public int size() {
        return cars.size();
    }

    public void move() {
        moveAllCar();
    }

    private void moveAllCar() {
        for (Car car : this.cars) {
            car.move(RandomValueGenerator.generate());
        }
    }

}

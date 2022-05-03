package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Cars {
    private final List<Car> cars;

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    static Cars initCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    void moveCars() {
        Moving moving = new MovingRandom();
        for (Car car : cars) {
            car.move(moving.move());
        }
    }

    List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}

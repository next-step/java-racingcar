package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author : 0giri
 * @since : 2023/04/16
 */
public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public void actionAll(Consumer<Car> action) {
        this.cars.parallelStream().forEach(action);
    }

    public int count() {
        return this.cars.size();
    }

    public List<Car> unmodifiableList() {
        return Collections.unmodifiableList(cars);
    }
}

package step3;

import java.util.ArrayList;
import java.util.List;

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

    public int count() {
        return this.cars.size();
    }
}

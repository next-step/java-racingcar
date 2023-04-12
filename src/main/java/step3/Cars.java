package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void add(Car car) {
        cars.add(car);
    }

    public int size() {
        return cars.size();
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public Car getCar(int i) {
        return cars.get(i);
    }

    public List<Car> getCars() {
        return cars;
    }
}

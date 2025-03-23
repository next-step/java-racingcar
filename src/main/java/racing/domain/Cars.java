package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<Car>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public Cars addCar(Car car) {
        this.cars.add(car);
        return this;
    }
}

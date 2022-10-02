package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public CarFactory() {
    }

    public Car makeCar() {
        return new Car();
    }

    public List<Car> makeCars(int number) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
        return cars;
    }

}

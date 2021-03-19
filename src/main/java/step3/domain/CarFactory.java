package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private final Cars cars;

    public CarFactory(int numberOfCars) {
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            list.add(new Car());
        }
        cars = new Cars(list);
    }

    public Cars getCars() {
        return cars;
    }
}

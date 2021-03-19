package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private final Cars cars;

    public CarFactory(int numberOfFactory) {
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < numberOfFactory; i++) {
            list.add(new Car());
        }
        cars = new Cars(list);
    }

    public Cars getCars() {
        return cars;
    }
}

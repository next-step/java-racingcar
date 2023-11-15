package step3;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public CarFactory() {
    }

    public Cars make(int howManyCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0 ; i < howManyCars; i++) {
            cars.add(Car.create());
        }
        return new Cars(cars);
    }
}

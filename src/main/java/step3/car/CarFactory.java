package step3.car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public List<Car> generateCar(int carCount) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}

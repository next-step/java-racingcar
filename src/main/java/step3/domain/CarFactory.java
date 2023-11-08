package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public List<Car> makeCar(int numberOfCar) {
        List<Car> preparedCar = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            Car newCar = new Car();
            preparedCar.add(newCar);
        }
        return preparedCar;
    }

}

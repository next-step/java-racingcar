package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public Cars createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for(String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return new Cars(cars);
    }
}

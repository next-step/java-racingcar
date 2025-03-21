package step4;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(new CarName(carName)));
        }
        return cars;
    }
}

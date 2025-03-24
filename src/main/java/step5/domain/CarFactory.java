package step5.domain;


import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static Cars createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }
}

package step5.domain;


import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static Cars createCars(CarNames carNames) {
        List<Car> cars = new ArrayList<>();
        for (CarName carName : carNames.getCarNames()) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }
}

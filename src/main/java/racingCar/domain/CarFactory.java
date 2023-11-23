package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public List<Car> makeCars(List<CarName> carNames) {
        List<Car> preparedCar = new ArrayList<>();
        for (CarName carName : carNames) {
            Car newCar = new Car(carName);
            preparedCar.add(newCar);
        }
        return preparedCar;
    }
}

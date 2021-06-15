package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarCreator {

    public Cars carFactory(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return new Cars(cars);
    }
}

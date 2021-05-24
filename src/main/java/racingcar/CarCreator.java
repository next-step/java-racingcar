package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarCreator {
    private List<Car> cars;

    public Cars player(String[] carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return new Cars(cars);
    }
}

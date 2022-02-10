package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(final List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName, 0));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}

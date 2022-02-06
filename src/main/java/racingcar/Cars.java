package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    private Cars(final List<String> carNames) {
        for (String carName : carNames) {
            cars.add(Car.of(carName));
        }
    }

    public static Cars of(final List<String> carNames) {
        return new Cars(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }
}

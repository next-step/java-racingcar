package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> value;

    private Cars(List<Car> value) {
        this.value = value;
    }

    public static Cars init(List<String> carNames) {
        List<Car> value = new ArrayList<>(carNames.size());

        for (String carName: carNames) {
            value.add(Car.create(carName, new SecureRandomPicker()));
        }

        return new Cars(value);
    }

    public List<String> game() {
        List<String> results = new ArrayList<>(value.size());

        for (Car car: value) {
            results.add(car.game().toString());
        }

        return results;
    }
}

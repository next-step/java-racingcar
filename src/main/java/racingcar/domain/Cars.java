package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> value;

    public Cars(int carCount) {
        List<Car> value = new ArrayList<>(carCount);

        for (int idx = 0; idx < carCount; idx++) {
            value.add(Car.create("car", new SecureRandomPicker()));
        }

        this.value = value;
    }

    public List<String> game() {
        List<String> results = new ArrayList<>(value.size());

        for (Car car: value) {
            results.add(car.game().toString());
        }

        return results;
    }
}

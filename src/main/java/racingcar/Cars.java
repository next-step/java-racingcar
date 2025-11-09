package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> values;

    public Cars(int count) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }

        this.values = cars;
    }

    public List<Car> getValues() {
        return List.copyOf(this.values);
    }
}

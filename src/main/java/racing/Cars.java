package racing;

import java.util.List;

public class Cars {

    List<Car> cars;

    Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(List<Car> cars) {
        if (cars.size() == 0)
            throw new IllegalArgumentException();

    }
}

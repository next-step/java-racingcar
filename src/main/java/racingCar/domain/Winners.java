package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> cars;

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> value() {
        return this.cars;
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for(Car car : cars) {
            names.add(car.getName());
        }
        return names;
    }

}

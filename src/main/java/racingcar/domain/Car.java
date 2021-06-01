package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private List<Cars> cars;

    public Car() {
        this.cars = new ArrayList<>();
    }

    public void add(String carName) {
        cars.add(new Cars(carName));
    }

    public List<Cars> getCars() {
        return cars;
    }
}

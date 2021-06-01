package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void add(String carName) {
        cars.add(new Car(carName));
    }

    public List<Car> getCars() {
        return cars;
    }
}

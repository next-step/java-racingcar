package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        names.forEach(name -> cars.add(new Car(name)));
    }

    public void attempt() {
        cars.forEach(Car::attempt);
    }

    public List<Car> getCars() {
        return cars;
    }

}

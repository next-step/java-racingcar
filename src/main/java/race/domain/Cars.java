package race.domain;

import race.utils.PlayStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> goForward(PlayStrategy rule) {
        for (Car car : this.cars) {
            goForwardWith(rule, car);
        }
        return this.cars;
    }

    private void goForwardWith(PlayStrategy rule, Car car) {
        if (rule.isValidForGoForward()) {
            car.go();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}

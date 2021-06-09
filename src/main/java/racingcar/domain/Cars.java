package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;
    private int cycle;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCars(String carName) {
        cars.add(new Car(carName));
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCycle() {
        return cycle;
    }
}

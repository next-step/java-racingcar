package step3.racingcar;

import java.util.List;

public class CarGroups {

    private final List<Car> carGroups;

    public CarGroups(List<Car> carGroups) {
        this.carGroups = carGroups;
    }

    public List<Car> getCarGroups() {
        return carGroups;
    }

    public void move() {
        this.carGroups.forEach(Car::move);
    }
}

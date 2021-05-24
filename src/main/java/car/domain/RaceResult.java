package car.domain;

import java.util.List;

public class RaceResult {
    private List<Car> cars;

    public RaceResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}

package racing.entity;

import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}

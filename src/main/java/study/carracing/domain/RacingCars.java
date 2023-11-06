package study.carracing.domain;

import java.util.List;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            cars.forEach(Car::move);
        }
    }
}

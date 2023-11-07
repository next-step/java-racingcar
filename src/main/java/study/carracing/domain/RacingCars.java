package study.carracing.domain;

import java.util.List;
import study.carracing.util.RandomNumberGenerator;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move(new RandomNumberGenerator().generatorNumber());
        }
    }
}

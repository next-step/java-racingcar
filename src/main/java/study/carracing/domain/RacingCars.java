package study.carracing.domain;

import java.util.ArrayList;
import java.util.List;
import study.carracing.util.RandomNumberGenerator;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
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

package study.carracing.domain;

import study.carracing.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(String[] carsName) {
        for (String name : carsName) {
            cars.add(new Car(name));
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

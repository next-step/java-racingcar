package racingcar.car;

import racingcar.engine.RandomEngine;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars createCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(Car.createCar());
        }
        return of(cars);
    }

    public void move() {
        for (Car car : cars) {
            car.move(RandomEngine.createCarEngine());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}

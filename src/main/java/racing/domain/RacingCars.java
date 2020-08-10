package racing.domain;

import racing.behavior.CarMovable;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(final List<Car> cars) {
        this.cars = cars;
    }

    public static RacingCars of(final int numberOfCar) {
        final List<Car> cars = new ArrayList<>();
        for(int i = 0; i < numberOfCar; i++) {
            cars.add(Car.of(new CarMovable()));
        }
        return new RacingCars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> raceOfCars(final List<Car> cars) {
        for (final Car car : cars) {
            car.move();
        }
        return cars;
    }
}

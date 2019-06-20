package racingcar.model;

import racingcar.util.drivingStrategy.DrivingStrategy;

import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(final String[] names) {
        this.cars = CarFactory.generate(names);
    }

    public Cars(final String[] names, final DrivingStrategy strategy) {
        this.cars = CarFactory.generate(names, strategy);
    }

    public List<Car> move() {
        this.cars.forEach(Car::move);
        return this.cars;
    }

    public List<Car> resetPosition() {
        this.cars.forEach(Car::resetPosition);
        return this.cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}

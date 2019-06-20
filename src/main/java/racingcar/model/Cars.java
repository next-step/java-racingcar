package racingcar.model;

import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(final String[] names) {
        this.cars = CarFactory.generate(names);
    }

    public List<Car> move() {
        this.cars.forEach(Car::move);
        return this.cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}

package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(int numberOfCars) {
        cars = Arrays.asList(new Car[numberOfCars]);
    }

    public void move() {
        cars.forEach(Car::move);
    }

}

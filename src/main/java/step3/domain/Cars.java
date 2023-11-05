package step3.domain;

import step3.utils.RandomUtils;

import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveForwardCars() {
        cars.stream().forEach(car -> car.tryMove(RandomUtils.generateRandomNumber()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}


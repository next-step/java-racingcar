package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private static final int RANDOM_MAX_BOUND = 10;
    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> carList() {
        return cars;
    }

    public void moveCars() {
        cars.forEach(car -> car.moveForward(new Random().nextInt(RANDOM_MAX_BOUND)));
    }

}

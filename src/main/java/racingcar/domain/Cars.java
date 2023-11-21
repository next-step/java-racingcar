package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cars {
    public static final int RANDOM_BOUND = 10;
    private final List<Car> cars = new ArrayList<>();

    public Cars() {
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public void moveCars() {
        for (Car car : this.cars) {
            car.moveForward(getRandomValue());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private int getRandomValue() {
        return new Random().nextInt(RANDOM_BOUND);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}

package domain;

import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveCars() {
        cars.forEach(car -> car.move(RandomNumberGenerator.getRandomNumber()));
    }

    public void printCarsPosition() {
        cars.forEach(Car::printPosition);
    }
}

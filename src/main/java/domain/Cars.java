package domain;

import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Integer> getCarsPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}

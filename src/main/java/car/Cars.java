package car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(int count) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            cars.add(new Car());
        }
        return new Cars(cars);
    }

    public void move() {
        for(Car car: cars) {
            car.move(new RandomMoveStrategy());
        }
    }

    public List<Integer> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}

package carracing;

import carracing.move_strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    private Cars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public static Cars makeCars(Integer carCount, MoveStrategy moveStrategy) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(moveStrategy));
        }
        return new Cars(cars);
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public Cars copyOf() {
        return new Cars(cars.stream().map(Car::clone).collect(Collectors.toList()));
    }
}

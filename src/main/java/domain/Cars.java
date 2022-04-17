package domain;

import util.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }

    public Positions moveCars(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
        return new Positions(cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()));
    }
}

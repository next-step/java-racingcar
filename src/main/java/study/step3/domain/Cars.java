package study.step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveForward(MoveStrategy moveStrategy) {
        cars.forEach(e -> e.moveForward(moveStrategy.createMove()));
    }

    public List<Integer> toPositionOfCars() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}

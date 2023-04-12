package carrace;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars;
    private final Movable movable;

    public Cars(int numberOfCars, Movable movable) {
        this.cars = IntStream.range(0, numberOfCars)
                .mapToObj(e -> new Car())
                .collect(Collectors.toList());
        this.movable = movable;
    }

    public void move() {
        for (Car car : cars) {
            car.move(movable.isMovable());
        }
    }

    public List<Integer> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}

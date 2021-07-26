package step5.model;

import step5.move.MovableStrategy;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    static public Cars of(String names) {
        return Arrays.stream(splitNames(names))
            .map(Car::new)
            .collect(collectingAndThen(toList(), Cars::new));
    }

    static public String[] splitNames(String name) {
        return name.split(",");
    }

    public void move(MovableStrategy movableStrategy) {
        cars.forEach(car -> car.move(movableStrategy));
    }

    public int countOfCars() {
        return cars.size();
    }

    public List<PointOfCar> getPointOfTime(int time) {
        return cars.stream().map(car -> car.getPointOfTime(time)).collect(toList());
    }
}

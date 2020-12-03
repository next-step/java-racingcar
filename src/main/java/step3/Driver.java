package step3;

import java.util.List;

public class Driver {

    private List<Car> cars;

    public Driver(List<Car> cars) {
        this.cars = cars;
    }

    public void drive() {
        this.cars.stream().forEach(car -> car.move(RandomGenerator.generate()));
    }

    public void currentDistance() {
        this.cars.stream().map(Car::getDistance).forEach(System.out::println);
    }

}

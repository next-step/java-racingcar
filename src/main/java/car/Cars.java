package car;

import strategy.MovingStrategy;
import strategy.RandomStrategy;

import java.util.*;

public class Cars {

    private final MovingStrategy strategy;
    private final List<Car> cars;

    public Cars(List<Car> cars, MovingStrategy strategy) {
        this.cars = cars;
        this.strategy = strategy;
    }

    public static Cars make(String[] nameOfCars) {
        List<Car> cars = new ArrayList<>();
        for (String nameOfCar : nameOfCars) {
            cars.add(new Car(nameOfCar));
        }

        return new Cars(cars, new RandomStrategy());
    }

    public List<Car> cars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.go(strategy);
        }
    }
}

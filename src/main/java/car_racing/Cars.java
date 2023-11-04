package car_racing;

import car_racing.move_strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars;
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
}

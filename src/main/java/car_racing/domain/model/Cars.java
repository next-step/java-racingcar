package car_racing.domain.model;

import car_racing.domain.strategy.CarMovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Cars {
    private static final int DEFAULT_MOVE_DISTANCE = 1;

    private final List<Car> cars;
    private final CarMovingStrategy movingStrategy;

    public Cars(int numOfCars, CarMovingStrategy movingStrategy) {
        this.cars = new ArrayList<>();
        this.movingStrategy = movingStrategy;
        for (int i = 0; i < numOfCars; i++) {
            this.cars.add(new Car());
        }
    }

    public void moveAll() {
        cars.forEach(car -> {
            if (movingStrategy.movable()) car.move(DEFAULT_MOVE_DISTANCE);
        });
    }

    public void forEach(Consumer<Car> action) {
        cars.forEach(action);
    }
}

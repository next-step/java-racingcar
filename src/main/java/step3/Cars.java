package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;
    private final MovingStrategy movingStrategy;

    public Cars(int numberOfCars, MovingStrategy movingStrategy) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        this.cars = cars;
        this.movingStrategy = movingStrategy;
    }

    public void moveAll() {
        cars.forEach((Car car) -> car.move(movingStrategy));
    }

    public StringBuilder status() {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append("-".repeat(car.getPosition())).append("\n");
        }
        return result;
    }
}

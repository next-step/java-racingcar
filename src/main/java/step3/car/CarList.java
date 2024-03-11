package step3.car;

import step3.RandomNumberCreator;
import step3.car.move.MoveStrategy;

import java.util.List;

public class CarList {
    private final List<Car> cars;

    public static CarList from(List<Car> cars) {
        return new CarList(cars);
    }

    public CarList(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        cars.stream().forEach(Car::move);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int[] createMoveResult() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .toArray();
    }
}

package step3.car;

import java.util.List;

public class CarFirstCollection {
    private final List<Car> cars;

    public static CarFirstCollection from(List<Car> cars) {
        return new CarFirstCollection(cars);
    }

    public CarFirstCollection(List<Car> cars) {
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

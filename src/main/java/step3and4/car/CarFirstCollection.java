package step3and4.car;

import java.util.ArrayList;
import java.util.List;

public class CarFirstCollection {
    private final List<Car> cars;

    public static CarFirstCollection from(List<Car> cars) {
        if (cars == null) {
            return new CarFirstCollection(new ArrayList<>());
        }
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

    public int size() {
        return this.getCars().size();
    }
}

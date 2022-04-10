package racingcar.model;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        this.cars.forEach(Car::move);
    }

    public int[] getAllPositions() {
        return this.cars.stream()
                .mapToInt(Car::getPosition)
                .toArray();
    }
}

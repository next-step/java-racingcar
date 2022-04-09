package racingcar.model;

import racingcar.generator.RandomNumberGenerator;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        this.cars.forEach(car ->
                car.move(new RandomNumberGenerator())
        );
    }

    public int[] getAllPositions() {
        return this.cars.stream()
                .mapToInt(Car::getPosition)
                .toArray();
    }
}

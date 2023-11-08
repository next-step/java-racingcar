package step3.domain;

import step3.util.RandomUtil;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int DEFAULT_POSITION = 0;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(RandomUtil randomUtil) {
        this.cars.stream()
            .forEach(car -> car.move(randomUtil.random()));
    }

    public Cars maxPositionCars() {
        Position maxPosition = maxPosition();

        return new Cars(this.cars.stream()
            .filter(car -> car.isSamePosition(maxPosition))
            .collect(Collectors.toList()));
    }

    private Position maxPosition() {
        Position maxPosition = new Position(DEFAULT_POSITION);
        for (Car car : cars) {
            maxPosition = maxPosition.greaterPosition(car.position());
        }
        return maxPosition;
    }

    public List<Car> cars() {
        return this.cars;
    }

}

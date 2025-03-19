package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.policy.CarMovementRandomizer;

public class Cars {

    private final List<Car> values;

    public Cars(List<Car> values) {
        this.values = new ArrayList<>(values);
    }

    public static Cars create(int carCount) {
        return new Cars(
            IntStream.range(0, carCount)
            .mapToObj(count -> Car.create())
            .collect(Collectors.toList())
        );
    }

    public List<Integer> getPositions() {
        return this.values.stream()
            .map(Car::getPosition)
            .collect(Collectors.toList());
    }

    public List<Car> getValues() {
        return this.values;
    }

    public void move() {
        this.values.forEach(car -> car.move(new CarMovementRandomizer()));
    }
}

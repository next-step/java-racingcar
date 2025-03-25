package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

import racingcar.policy.CarMovementRandomizer;
import racingcar.utils.NumberUtils;

public class Cars {

    private final List<Car> values;

    public Cars(List<Car> values) {
        this.values = new ArrayList<>(values);
    }

    public static Cars create(List<String> names) {
        return new Cars(
            names.stream()
                .map(Car::create)
                .collect(Collectors.toList())
        );
    }

    public Cars move() {
        return new Cars(getValues().stream()
            .map(car -> car.move(new CarMovementRandomizer()))
            .collect(Collectors.toList()));
    }

    public List<Car> getValues() {
        return this.values;
    }

    public List<String> getWinnerNames() {
        return getValues().stream()
            .filter(car -> car.equals(NumberUtils.getMax(getPositions())))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    public List<Integer> getPositions() {
        return getValues().stream()
            .map(Car::getPosition)
            .collect(Collectors.toList());
    }
}

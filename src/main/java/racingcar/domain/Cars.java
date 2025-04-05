package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

import racingcar.policy.CarMovementRandomizer;
import racingcar.vo.CarPosition;

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

    public CarPosition getMaxPosition() {
        return getValues().stream()
            .map(Car::getPosition)
            .max(Comparator.comparingInt(CarPosition::getValue))
            .orElse(CarPosition.initialize());
    }
}

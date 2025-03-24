package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.policy.CarMovementRandomizer;

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
        return new Cars(this.values.stream()
            .map(car -> car.move(new CarMovementRandomizer()))
            .collect(Collectors.toList()));
    }

    public List<Car> getValues() {
        return this.values;
    }

    public List<Integer> getPositions() {
        return this.values.stream()
            .map(Car::getPosition)
            .collect(Collectors.toList());
    }
}

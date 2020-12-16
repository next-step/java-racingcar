package step3.domain;

import step3.domain.rule.MoveRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(int carCount) {
        cars.addAll(Stream.generate(Car::new)
                .limit(carCount)
                .collect(Collectors.toList()));
    }

    public void moveAll(int roundTime, MoveRule moveRule) {
        cars.forEach(car -> car.move(roundTime, moveRule.canMove()));
    }

    public List<Car> getValue() {
        return Collections.unmodifiableList(cars);
    }
}

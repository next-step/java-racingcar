package racingcar.backend.domain;

import racingcar.backend.strategy.MoveStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(final String[] names) {
        return new Cars(Arrays.asList(names).stream()
                .map(name -> Car.create(new CarName(name), new Position(0)))
                .collect(Collectors.toList()));
    }

    public Cars move(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
        return this;
    }

    public List<Car> getValues() {
        return new ArrayList<>(cars);
    }
}

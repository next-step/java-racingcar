package racinggame.car;

import racinggame.utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Round {

    private static final int BOUND = 10;
    private static final int MOVABLE_MINIMUM_NUMBER = 4;

    private final List<Position> result;

    private Round(List<Car> cars) {
        this.result = cars.stream().map(Car::position).collect(Collectors.toList());
    }

    public static Round start(List<Car> cars) {
        for (final var car : cars) {
            car.move(() ->
                    RandomUtils.getRandomNumber(BOUND) >= MOVABLE_MINIMUM_NUMBER);
        }
        return new Round(cars);
    }

    public List<Position> result() {
        return this.result;
    }

}

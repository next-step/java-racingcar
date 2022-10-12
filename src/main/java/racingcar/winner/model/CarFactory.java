package racingcar.winner.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    private final String[] splitCarNames;

    public CarFactory(final String[] splitCarNames) {
        this.splitCarNames = splitCarNames;
    }

    public List<Car> build() {
        return Arrays.stream(splitCarNames)
                     .map(CarName::new)
                     .map(Car::new)
                     .collect(Collectors.toList());
    }
}

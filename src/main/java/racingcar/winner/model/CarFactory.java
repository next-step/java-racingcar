package racingcar.winner.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    private final String[] splittedCarNames;

    public CarFactory(final String[] splittedCarNames) {
        this.splittedCarNames = splittedCarNames;
    }

    public List<Car> build() {
        return Arrays.stream(splittedCarNames)
                     .map(CarName::new)
                     .map(Car::new)
                     .collect(Collectors.toList());
    }
}

package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private CarFactory() {
        throw new AssertionError();
    }

    public static List<Car> generateCars(List<CarName> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}

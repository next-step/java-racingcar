package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static List<Car> createCars(final List<String> carNames) {
        return carNames.stream()
            .map(carName -> new Car(carName))
            .collect(Collectors.toList());
    }

}

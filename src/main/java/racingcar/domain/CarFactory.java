package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private CarFactory() {
        throw new AssertionError();
    }

    public static Cars generateCars(List<CarName> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }
}

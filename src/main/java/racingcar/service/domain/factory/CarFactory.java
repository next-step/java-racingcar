package racingcar.service.domain.factory;

import racingcar.service.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public final class CarFactory {
    private CarFactory() {
    }

    public static List<Car> createCar(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}

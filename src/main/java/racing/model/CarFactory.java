package racing.model;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    public static List<Car> createCarsByNames(List<String> carNames) {
        return carNames.stream()
                .map(Car::of)
                .collect(Collectors.toList());
    }
}

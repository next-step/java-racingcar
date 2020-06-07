package racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class CarFactory {
    private CarFactory() {}

    public static List<Car> generateCars(final String carNames) {
        return Arrays.stream(NameParser.parse(carNames))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}

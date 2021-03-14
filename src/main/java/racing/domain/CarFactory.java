package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    private CarFactory() {}

    public static Cars generateCars(List<String> names) {
        return new Cars(names.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }
}

package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarGenerator {

    private CarGenerator() {
    }

    public static List<Car> createCars(List<String> carNames, MoveRule moveRule) {
        return carNames.stream()
            .map(carName -> new Car(carName.trim(), moveRule))
            .collect(Collectors.toList());
    }
}

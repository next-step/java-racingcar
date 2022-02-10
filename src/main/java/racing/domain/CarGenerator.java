package racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarGenerator {

    private static final String SPLIT_DELIMITER = ",";

    private CarGenerator() {
    }

    public static List<Car> createCars(String carNames, MoveRule moveRule) {

        return Arrays.stream(carNames.split(SPLIT_DELIMITER))
            .map(m -> new Car(m, moveRule))
            .collect(Collectors.toList());
    }
}

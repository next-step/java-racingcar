package racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarGenerator {

    private static final String SPLIT_DELIMITER = ",";

    private CarGenerator() {
    }

    public static List<Car> createCars(String carNames) {

        final MoveRule rule = new MoveRule(4);

        return Arrays.stream(carNames.split(SPLIT_DELIMITER))
            .map(m -> new Car(m, rule))
            .collect(Collectors.toList());
    }
}

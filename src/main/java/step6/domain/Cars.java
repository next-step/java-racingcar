package step6.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String CAR_NAMES_DELIMITER = ",";
    private final List<Car> cars;

    public Cars(String inputCarName) {
        this.cars = validCarNames(Arrays.asList(inputCarName.split(CAR_NAMES_DELIMITER)));
    }

    private List<Car> validCarNames(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }
}

package step6.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNames {
    private static final String CAR_NAMES_DELIMITER = ",";
    private final List<CarName> carNames;

    public CarNames(String inputCarName) {
        this.carNames = validCarNames(Arrays.asList(inputCarName.split(CAR_NAMES_DELIMITER)));
    }

    private List<CarName> validCarNames(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new CarName(carName))
                .collect(Collectors.toList());
    }
}

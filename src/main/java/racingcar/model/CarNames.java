package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class CarNames {
    private final List<String> carNames;

    public CarNames(String carNames) {
        this.carNames = Arrays.asList(carNames.split(","));
    }
}

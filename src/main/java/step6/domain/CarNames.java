package step6.domain;

import java.util.Arrays;
import java.util.List;

public class CarNames {
    private static final String CAR_NAMES_DELIMITER = ",";
    private final List<CarName> carNames;

    public CarNames(String inputCarName) {
        Arrays.asList(inputCarName.split(CAR_NAMES_DELIMITER));
    }


}

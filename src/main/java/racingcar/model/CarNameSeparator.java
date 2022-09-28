package racingcar.model;

import java.util.List;

public class CarNameSeparator {

    private static final String SEPARATOR = ",";

    public static List<String> separateNames(String carNames) {
        return List.of(carNames.split(SEPARATOR));
    }

}

package racingcar.view;

import java.util.List;

public class CarNameSeparator {

    private static final String SEPARATOR = ",";

    public static List<String> separate(String carNames) {
        return List.of(carNames.split(SEPARATOR));
    }

}

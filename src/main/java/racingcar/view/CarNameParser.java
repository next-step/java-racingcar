package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameParser {
    private CarNameParser() {
    }

    public static List<String> parseWhiteSpaceCarNamesString(String carNames) {
        String[] carNameArray = carNames.trim()
                .replaceAll("\\s+", ",")
                .split(",");

        return Arrays.stream(carNameArray)
                .collect(Collectors.toList());
    }

    public static List<String> parseCommaCarNamesString(String carNames) {
        String[] carNameArray = carNames.trim()
                .split(",");

        return Arrays.stream(carNameArray)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}

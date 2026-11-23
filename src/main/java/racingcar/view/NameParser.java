package racingcar.view;

import racingcar.domain.CarName;

import java.util.Arrays;
import java.util.List;

public class NameParser {
    private static final String DELIMITER = ",";
    private static final int KEEP_TRAILING_EMPTY = -1;

    private NameParser() {
    }

    public static List<CarName> parse(String input) {
        validateNotBlank(input);
        return Arrays.stream(input.split(DELIMITER, KEEP_TRAILING_EMPTY))
                .map(String::trim)
                .map(CarName::new)
                .toList();
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("car names are required");
        }
    }
}

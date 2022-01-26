package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private Parser() {}

    public static List<String> parseCarNames(final String carNames) {
        String NAME_SPLITTER = ",";
        return Arrays.stream(carNames.split(NAME_SPLITTER))
            .map(String::trim)
            .collect(Collectors.toList());
    }
}

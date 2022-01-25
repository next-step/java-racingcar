package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private Parser() {}

    public static List<String> parseCarNames(String carNames) {
        String NAME_SPLITTER = ",";
        return Arrays.stream(carNames.split(NAME_SPLITTER))
            .collect(Collectors.toList());
    }
}

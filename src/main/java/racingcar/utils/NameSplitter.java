package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameSplitter {

    private static final String SPLIT_DELIMITER = ",";

    public static List<String> splitUserName(final String inputNames) {
        return Arrays.stream(inputNames.split(SPLIT_DELIMITER))
            .map(String::trim)
            .collect(Collectors.toList());
    }

}

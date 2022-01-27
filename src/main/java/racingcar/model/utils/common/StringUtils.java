package racingcar.model.utils.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    private static final String DELIMITER = ",";

    public static List<String> splitStr(final String userInput) {
        return Arrays.stream(userInput.split(DELIMITER)).collect(Collectors.toList());
    }
}

package racingcar.view;

import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");

    private static final String INVALID_NUMBER_MESSAGE = "숫자가 아닌 값이 포함되어 있습니다.";


    public static void validateNumber(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

}

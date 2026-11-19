package racingcar.view;

import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");
    private static final Pattern NAMES_PATTERN = Pattern.compile("[^,\\s]+(,[^,\\s]+)*");


    private static final String INVALID_NUMBER_MESSAGE = "숫자가 아닌 값이 포함되어 있습니다.";
    private static final String INVALID_NAMES_MESSAGE = "이름은 쉼표(,)로 구분해 공백 없이 입력해야 합니다. 예: pobi,crong,honux";


    public static void validateNumber(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

    public static void validateNames(String input) {
        if (!NAMES_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_NAMES_MESSAGE);
        }
    }

}

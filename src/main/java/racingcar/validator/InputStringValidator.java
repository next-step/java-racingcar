package racingcar.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputStringValidator {

    private static final Pattern onlyNumberPattern = Pattern.compile("^[0-9]*$");

    private static final String WRONG_INPUT_ERROR_MESSAGE = "잘못된 입력값 입니다";

    public static int valid(String input) {
        Matcher matcher = onlyNumberPattern.matcher(input);

        if(matcher.find()) {
            return checkPositive(input);
        }

        throw new IllegalArgumentException(WRONG_INPUT_ERROR_MESSAGE);
    }

    private static int checkPositive(String input) {
        int number = Integer.parseInt(input);

        if(number < 0) {
            throw new IllegalArgumentException(WRONG_INPUT_ERROR_MESSAGE);
        }

        return number;

    }
}

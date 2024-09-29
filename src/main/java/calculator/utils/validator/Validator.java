package calculator.utils.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String CUSTOM_DELIMETER = "//(.)\n(.*)";

    private static final Pattern positiveNumberPattern = Pattern.compile("^\\d+$");

    public static boolean validateUserInput(String text) {
        if (isNull(text) || isEmpty(text)) {
            return false;
        }
        return true;
    }

    private static boolean isEmpty(String text) {
        return text.isEmpty();
    }

    private static boolean isNull(String text) {
        return text == null;
    }

    public static boolean hasCustomDelimeter(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMETER).matcher(text);
        return m.find();
    }

    public static boolean isValidNumber(String num) {
        if (!isNumber(num) || !isPositiveNumber(num)) {
            throw new IllegalArgumentException(String.format("양의 정수를 입력해주세요! 입력값 : %s", num));
        }
        return true;
    }

    private static boolean isNumber(String text) {
        return positiveNumberPattern.matcher(text).matches();
    }

    private static boolean isPositiveNumber(String text) {
        int num = Integer.parseInt(text);
        if (num < 0) {
            return false;
        }
        return true;
    }

}

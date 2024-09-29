package calculator.utils.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String CUSTOM_DELIMETER = "//(.)\n(.*)";

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
}

package study.step2.common;

import java.util.regex.Pattern;

public class StringUtil {

    private final static String SEPERATOR = " ";
    private final static String NUMBERPATTERN = "^[0-9]+$";

    public static boolean isBlank(String input) {
        if (input == null || input.trim().isEmpty()){
            return true;
        }
        return false;
    }

    public static String [] seperateNumberAndOperator(String input) {
        blankMakeException(input);
        return input.split(SEPERATOR);
    }

    public static boolean isNumber(String value){
        blankMakeException(value);
        return Pattern.matches(NUMBERPATTERN, value);
    }

    private static void blankMakeException(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }
}

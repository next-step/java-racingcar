package util;

import java.util.regex.Pattern;

public class Strings {
    public static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
    public static boolean isNumber(String input) {
        return Pattern.matches("^[0-9.]+", input);
    }
    public static boolean isCalculate(String input) {
        return Pattern.matches("|\\(|\\)|\\+|\\-|\\*|\\/", input);
    }

}
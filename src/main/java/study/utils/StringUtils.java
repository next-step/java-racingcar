package study.utils;

import study.validator.NameValidator;

import java.util.regex.Pattern;

public class StringUtils {
    private static final String PATTERN = ",";

    public static String[] splitStringAndValidateNames(String input) {
        String[] names = StringUtils.splitString(input);
        for (String name : names) {
            NameValidator.carsNameValidator(name);
        }
        return names;
    }

    public static String[] splitString(String input) {
        return input.split(PATTERN);
    }
}

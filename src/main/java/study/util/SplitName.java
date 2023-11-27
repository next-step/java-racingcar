package study.util;

import study.validator.NameValidator;

public class SplitName {
    private static final String PATTERN = ",";

    public static String[] splitStringAndValidateNames(String input) {
        String[] names = SplitName.splitString(input);
        for (String name : names) {
            NameValidator.carsNameValidator(name);
        }
        return names;
    }

    public static String[] splitString(String input) {
        return input.split(PATTERN);
    }
}

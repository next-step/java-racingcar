package study.carracing.util;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");
    private static final Pattern CARS_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)*$");
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAMES_DELIMITER = ",";

    public static int validateNumber(int input) {
        if (isNotNumberOrNegative(input)) {
            throw new IllegalArgumentException("숫자 이외의 값 또는 음수가 입력됐습니다." + input);
        }

        return input;
    }

    public static String[] validateCarName(String input) {
        if (isNotCarsName(input)) {
            throw new IllegalArgumentException("형식에 맞지 않는 값이 입력됐습니다." + input);
        }

        String[] names = input.split(NAMES_DELIMITER);
        for (String name : names) {
            checkNameLength(name);
        }

        return names;
    }

    private static void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException("자동차의 이름은 5자를 초과할 수 없습니다." + name);
        }
    }

    public static boolean isNotNumberOrNegative(int input) {
        return !NUMBER_PATTERN.matcher(String.valueOf(input)).matches();
    }

    public static boolean isNotCarsName(String input) {
        return !CARS_NAME_PATTERN.matcher(String.valueOf(input)).matches();
    }
}

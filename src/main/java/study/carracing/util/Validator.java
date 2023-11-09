package study.carracing.util;

import study.carracing.exceptions.InvalidNameException;
import study.carracing.exceptions.InvalidNumberException;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final Pattern NAMES_PATTERN = Pattern.compile("^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)*$");
    private static final String NAMES_DELIMITER = ",";

    public static int validateNumber(int number) {
        if (!isNumber(number)) {
            throw new InvalidNumberException("숫자 이외의 값 또는 음수가 입력됐습니다." + number);
        }

        return number;
    }

    public static String[] validateCarName(String names) {
        if (!isMatchesNamesPattern(names)) {
            throw new InvalidNameException("형식에 맞지 않는 값이 입력됐습니다." + names);
        }

        return names.split(NAMES_DELIMITER);
    }

    private static boolean isNumber(int number) {
        return NUMBER_PATTERN.matcher(String.valueOf(number)).matches();
    }

    private static boolean isMatchesNamesPattern(String names) {
        return NAMES_PATTERN.matcher(String.valueOf(names)).matches();
    }
}

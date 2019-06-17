package racingcar.model;

import com.google.common.base.Strings;

import java.util.regex.Pattern;


public class CarsValidator {

    public static final int MIN_CARS_COUNT = 2;
    static final String REGEX_CAR_NAMES_PATTERN = "^[\\w*]*(?:,\\w*)*[\\w+]$";
    private static Pattern pattern = Pattern.compile(REGEX_CAR_NAMES_PATTERN);

    public static void validate(String names) {
        validateEmpty(names);
        validatePattern(names.replace(" ", ""));
    }

    public static void validateCount(int count) {
        if (MIN_CARS_COUNT > count) {
            throw new CarNameException(MIN_CARS_COUNT + "이상 입력해주세요.");
        }
    }

    private static void validateEmpty(String name) {
        if (name == null || Strings.isNullOrEmpty(name.trim())) {
            throw new CarNameException("이름을 입력하세요.");
        }
    }

    private static void validatePattern(String name) {
        if (!pattern.matcher(name).find()) {
            throw new CarNameException("잘못된 입력입니다. 구분자: ,");
        }
    }
}

package racingcar.model;

import com.google.common.base.Strings;

import java.util.regex.Pattern;


public class NamesValidator {

    static final String CAR_NAMES_DELIMITER = ",";
    static final String REGEX_CAR_NAMES_PATTERN = "^[가-힣\\w]+(,[가-힣\\w]+)*$";
    private static Pattern pattern = Pattern.compile(REGEX_CAR_NAMES_PATTERN);

    public static void validate(String names) {
        validateEmpty(names);
        validatePattern(names);
    }

    private static void validateEmpty(String name) {
        if (name == null || Strings.isNullOrEmpty(name.trim())) {
            throw new IllegalArgumentException("빈 문자열 입니다");
        }
    }

    private static void validatePattern(String names) {
        if (!pattern.matcher(names).matches()) {
            throw new IllegalArgumentException("잘못된 입력입니다. 구분자: " + CAR_NAMES_DELIMITER);
        }
    }
}

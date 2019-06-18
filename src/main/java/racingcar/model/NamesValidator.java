package racingcar.model;

import com.google.common.base.Strings;

import java.util.regex.Pattern;


public class NamesValidator {

    static final String REGEX_CAR_NAMES_PATTERN = "^[\\w*]*(?:,\\w*)*[\\w+]$";
    private static Pattern pattern = Pattern.compile(REGEX_CAR_NAMES_PATTERN);

    public static void validate(String names) {
        validateEmpty(names);
        validatePattern(names);
    }

    private static void validateEmpty(String name) {
        if (name == null || Strings.isNullOrEmpty(name.trim())) {
            throw new NameException("빈 문자열 입니다");
        }
    }

    private static void validatePattern(String names) {
        if (!pattern.matcher(names).find()) {
            throw new NameException("잘못된 입력입니다. 구분자: ,");
        }
    }
}

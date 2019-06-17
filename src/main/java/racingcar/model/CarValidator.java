package racingcar.model;

import com.google.common.base.Strings;

import java.util.regex.Pattern;


public class CarValidator {

    public static final int NAME_LENGTH_LIMIT = 10;
    static final String REGEX_PATTERN = "^[\\w]*$";
    private static Pattern pattern = Pattern.compile(REGEX_PATTERN);

    public static void validate(String name) {
        validateEmpty(name);
        validateLength(name);
        validatePattern(name);
    }

    private static void validateEmpty(String name) {
        if (name == null || Strings.isNullOrEmpty(name.trim())) {
            throw new CarNameException("이름을 입력하세요.");
        }
    }

    private static void validateLength(String name) {
        if (NAME_LENGTH_LIMIT < name.length()) {
            throw new CarNameException("이름은 " + NAME_LENGTH_LIMIT + "이하여야 합니다.");
        }
    }

    private static void validatePattern(String name) {
        if (!pattern.matcher(name).find()) {
            throw new CarNameException("이름은 영문 숫자 특수문자(_)만 가능합니다.");
        }
    }
}

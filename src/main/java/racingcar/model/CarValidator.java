package racingcar.model;

import com.google.common.base.Strings;

import java.util.regex.Pattern;


public class CarValidator {

    public static final int NAME_LENGTH_LIMIT = 10;
    public static final String REGEX_PATTERN = "^[a-zA-Z가-힇]*$";

    private static Pattern pattern = Pattern.compile(REGEX_PATTERN);

    public static void validate(String name){
        validateEmpty(name);
        validatePattern(name);
        validateLength(name);
    }

    private static void validateEmpty(String name) {
        if (name == null || Strings.isNullOrEmpty(name.trim())) {
            throw new CarNameException("name doesn't empty");
        }
    }

    private static void validateLength(String name) {
        if (NAME_LENGTH_LIMIT < name.length()) {
            throw new CarNameException("이름은 " + NAME_LENGTH_LIMIT + "이하여야 합니다.");
        }
    }

    private static void validatePattern(String name) {
        if (!pattern.matcher(name).find()) {
            throw new CarNameException("이름은 영문 또는 한글만 가능합니다.");
        }
    }

}

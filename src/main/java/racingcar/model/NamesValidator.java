package racingcar.model;

import java.util.regex.Pattern;


public class NamesValidator {

    static final String REGEX_CAR_NAMES_PATTERN = "^[\\w*]*(?:,\\w*)*[\\w+]$";
    private static Pattern pattern = Pattern.compile(REGEX_CAR_NAMES_PATTERN);

    public static void validate(String names) {
        if (!pattern.matcher(names).find()) {
            throw new NameException("잘못된 입력입니다. 구분자: ,");
        }
    }
}

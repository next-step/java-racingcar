package racingcar.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String NUMERIC_REGEXP = "\\d";
    private static final Pattern NUMERIC_PATTERN = Pattern.compile(NUMERIC_REGEXP);
    public static final int MAX = 9;
    public static final int MIN = 0;

    public void nullCheck(String input) {
        if (input == null || input.isBlank()) {
            throw new RuntimeException("입력이 되지 않았습니다");
        }
    }

    public void numericCheck(String input) {
        Matcher matcher = NUMERIC_PATTERN.matcher(input);
        if (!matcher.find()) {
            throw new RuntimeException("숫자를 입력해주세요");
        }
        numberRangeCheck(input);
    }

    private void numberRangeCheck(String input) {
        Integer number = Integer.parseInt(input);
        if (number > MAX || number < MIN) {
            throw new RuntimeException("숫자의 입력 범위가 잘 못 되었습니다");
        }
    }

}

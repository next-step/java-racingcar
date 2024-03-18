package racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidator {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d");
    public static final int MIN_DISTANCE = 0;

    public void nullCheck(String input) {
        if (input == null || input.isBlank()) {
            throw new RuntimeException("빈 값이 입력되었습니다.");
        }
    }

    public void numericCheck(String input) {
        Matcher matcher = NUMERIC_PATTERN.matcher(input);
        if (!matcher.find()) {
            throw new RuntimeException("숫자만 입력해주세요.");
        }
        numberCheck(input);
    }

    private void numberCheck(String input) {
        Integer number = Integer.parseInt(input);
        if (number < MIN_DISTANCE) {
            throw new RuntimeException("0-9 사이의 숫자를 입력해주세요.");
        }
    }

}

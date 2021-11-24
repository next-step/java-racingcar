package calculator;

import java.util.Objects;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[+-]?\\d*(\\.?\\d*)$");
    private static final Pattern BLANK_PATTERN = Pattern.compile("\\s*");

    public static void numberValidation(String input) {
        if (Objects.isNull(input) || !isNumber(input)) {
            throw new IllegalArgumentException("숫자가 아닌 값을 숫자로 변환할 수 없습니다. 입력값 = " + input);
        }
    }

    public static void dividerValidation(int divider) {
        if (divider == 0) {
            throw new ArithmeticException("0 은 나눗셈을 할 수 없습니다. 다시 입력해주세요.");
        }
    }

    public static void argumentValidation(String input) {
        if (Objects.isNull(input) || BLANK_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("유효하지 않은 입력값 입니다. 공백을 입력하지 마세요.");
        }
    }

    public static void operatorValidation(String operator) {
        if (!Operator.contains(operator)) {
            throw new IllegalArgumentException(operator + " 는 유효하지 않은 사칙연산 기호입니다. +, -, *, / 중 한개를 입력하세요.");
        }
    }

    private static boolean isNumber(String input) {
        return NUMBER_PATTERN.matcher(input).matches();
    }

}

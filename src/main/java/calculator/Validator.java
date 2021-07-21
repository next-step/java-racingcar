package calculator;

import java.util.Arrays;

public class Validator {
    private static final String[] operators = {"+", "-", "*", "/"};

    public static void checkInputValidation(String inputStr) {
        checkNullValidation(inputStr);
        checkArrayValidation(inputStr.split(" "));
    }

    private static void checkNullValidation(String inputStr) {
        if (inputStr == null) {
            throw new IllegalArgumentException("입력 값이 NULL입니다.");
        }
    }

    private static void checkArrayValidation(String[] values) {
        if (values == null || Arrays.stream(values).anyMatch(s -> s == null || s.isEmpty())) {
            throw new IllegalArgumentException("입력 값에 빈값 또는 NULL이 포함돼있습니다.");
        }
    }

    public static void checkCalculateValidation(String operator, String num1, String num2) {
        checkOperatorValidation(operator);
        checkNumberValidation(num1, num2);
    }

    private static void checkOperatorValidation(String operator) {
        if (Arrays.stream(operators).noneMatch(o -> o.equals(operator))) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }

    private static void checkNumberValidation(String num1, String num2) {
        try {
            Integer.parseInt(num1);
            Integer.parseInt(num2);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("올바른 숫자가 아닙니다.");
        }
    }

}

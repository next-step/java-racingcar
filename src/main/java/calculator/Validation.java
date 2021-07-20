package calculator;

import java.util.Arrays;

public class Validation {
    private final String[] operators = {"+", "-", "*", "/"};

    public String checkInputValidation(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 NULL입니다.");
        }
        return input;
    }

    public void checkValidation(String[] values) {
        if (Arrays.asList(values).contains("") || Arrays.asList(values).contains(null)) {
            throw new IllegalArgumentException("입력 값에 빈값 또는 NULL이 포함돼있습니다.");
        }
    }

    public void checkValidation(String operator, String num1, String num2) {
        if (!Arrays.asList(operators).contains(operator)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }

        checkValidation(num1, num2);

    }

    public void checkValidation(String num1, String num2) {
        try {
            Integer.parseInt(num1);
            Integer.parseInt(num2);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("올바른 숫자가 아닙니다.");
        }
    }

}

package calculator.util;

import java.util.List;

public class IsValidInput {
    private static final int FIRST_OPERATOR = 1;
    private static final int FIRST_NUMBER = 0;
    private static final int DISTANCE = 2;

    public static void isBlankOrNot(String input) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException("입력값이 Null이거나 빈 공백 문자입니다!");
        }
    }

    public static void isNotOperator(List<String> formular) {
        int inputMaxLength = formular.size();
        for (int i = FIRST_OPERATOR; i < inputMaxLength; i += DISTANCE) {
            Operation.fromString(formular.get(i))
                .orElseThrow(() ->
                    new IllegalArgumentException("사칙연산 기호가 아닙니다.")
                );
        }
    }

    public static void isNotNumber(List<String> formular) {
        int inputMaxLength = formular.size();
        for (int i = FIRST_NUMBER; i < inputMaxLength; i += DISTANCE) {
            try {
                Integer.parseInt(formular.get(i));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("피연산자가 숫자가 아닙니다.");
            }
        }
    }
}

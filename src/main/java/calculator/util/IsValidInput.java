package calculator.util;

import java.util.List;

public class IsValidInput {

    public static void isBlankOrNot(String input) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException("입력값이 Null이거나 빈 공백 문자입니다!");
        }
    }

    public static void isNotOperator(List<String> formular) {
        for (int i = 1; i < formular.size(); i += 2) {
            Operation.fromString(formular.get(i))
                .orElseThrow(() ->
                    new IllegalArgumentException("사칙연산 기호가 아닙니다.")
                );
        }
    }

    public static void isNotNumber(List<String> formular) {
        for (int i = 0; i < formular.size(); i += 2) {
            try {
                Integer.parseInt(formular.get(i));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("피연산자가 숫자가 아닙니다.");
            }
        }
    }
}

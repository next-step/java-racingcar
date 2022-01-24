package calculator.ui;

import calculator.util.ExpressionUtil;
import calculator.util.Operation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExpressionInput {

    private ExpressionInput() {
    }

    public static List<String> getExpression() {
        List<String> formular = new ArrayList<>();

        System.out.println("계산할 연산식을 입력해주세요.");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = bufferedReader.readLine();
            isBlankOrNot(input);

            formular = ExpressionUtil.split(input);
            isNotOperator(formular);
            isNotNumber(formular);
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return formular;
    }

    private static void isBlankOrNot(String input) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException("입력값이 Null이거나 빈 공백 문자입니다!");
        }
    }

    private static void isNotOperator(List<String> formular) {
        for (int i = 1; i < formular.size(); i += 2) {
            Operation.fromString(formular.get(i))
                .orElseThrow(() ->
                    new IllegalArgumentException("사칙연산 기호가 아닙니다.")
                );
        }
    }

    private static void isNotNumber(List<String> formular) {
        for (int i = 0; i < formular.size(); i += 2) {
            try {
                Integer.parseInt(formular.get(i));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("피연산자가 숫자가 아닙니다.");
            }
        }
    }
}

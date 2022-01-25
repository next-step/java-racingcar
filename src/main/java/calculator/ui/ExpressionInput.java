package calculator.ui;

import calculator.util.ExpressionUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExpressionInput {

    private ExpressionInput() {
    }

    public static List<String> getExpression() {
        List<String> expression = new ArrayList<>();

        System.out.println("계산할 연산식을 입력해주세요.");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = bufferedReader.readLine();
            validateBlankOrNot(input);
            expression = ExpressionUtil.split(input);
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return expression;
    }

    private static void validateBlankOrNot(String input) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException("[ERROR] 입력값이 Null이거나 빈 공백 문자입니다!");
        }
    }

}

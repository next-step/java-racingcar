package calculator.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    public static String input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean validate(String expression) {
        return ExpressionValidator.validate(expression);
    }

    //TODO: operator 와 operand 로 분리 반환 개선 필요
    public static String[] splitExpression(String expression) {
        return expression.split(" ");
    }
}

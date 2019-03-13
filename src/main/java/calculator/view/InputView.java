package calculator.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static final String DELIMITER = " ";

    public String[] input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String text = br.readLine();
            if (!validate(text)) {
                return null;
            }

            return splitExpression(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean validate(String expression) {
        return ExpressionValidator.validate(expression);
    }

    //TODO: operator 와 operand 로 분리 반환 개선 필요
    private static String[] splitExpression(String expression) {
        return expression.split(DELIMITER);
    }
}

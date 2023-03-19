package calculator;

import java.util.Arrays;
import java.util.List;

public class OperationVerifier {

    private static final String SPLIT_SYMBOL = " ";

    public static List<String> verifyExpression(String expression) {
        if(expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 올바르지 않습니다.");
        }

        return splitExpression(expression);
    }

    private static List<String> splitExpression(String expression) {
        List<String> results = Arrays.asList(expression.split(SPLIT_SYMBOL));
        if(results.size() % 2 == 0) {
            throw new IllegalArgumentException("유효하지 않은 수식이 입력되었습니다.");
        }
        return results;
    }

    public static int verifyOperand(String operand) {
        try {
            return Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 피연산자가 숫자가 아닙니다.");
        }
    }

}

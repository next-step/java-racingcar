package calculator;

import java.util.Arrays;
import java.util.List;
import utils.StringUtils;

public class Calculator {

    public static final String SPLIT_DELIMITER = " ";

    public static int calculate(String input) {
        if (StringUtils.isNullOrEmpty(input)) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }
        return calculate(splitTokens(input));
    }

    private static int calculate(List<String> tokens) {
        int result = getElementFromTokensList(tokens, 0);
        for (int i = 1; i < tokens.size(); i += 2) {
            String operator = tokens.get(i);
            int number = getElementFromTokensList(tokens, i + 1);
            result = calculate(result, number, operator);
        }
        return result;
    }

    private static int getElementFromTokensList(List<String> tokens, int i) {
        return Integer.parseInt(tokens.get(i));
    }

    private static List<String> splitTokens(String input) {
        return Arrays.asList(input.split(SPLIT_DELIMITER));
    }

    private static int calculate(int first, int second, String operator) {
        validateOperator(operator);
        if (operator.equals("+")) {
            return first + second;
        } else if (operator.equals("-")) {
            return first - second;
        } else if (operator.equals("*")) {
            return first * second;
        } else if (operator.equals("/")) {
            return first / second;
        }
        return 0;
    }

    private static void validateOperator(String operator) {
        if (StringUtils.isNullOrEmpty(operator)) {
            throw new IllegalArgumentException("연산자가 비어 있습니다.");
        }
        if (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator
                .equals("/")) {
            throw new IllegalArgumentException("사칙 연산만이 가능합니다");
        }
    }
}

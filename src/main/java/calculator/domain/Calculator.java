package calculator.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import utils.StringUtils;

public class Calculator {

    public static final String SPACE = "\\s+";

    public static int calculate(String input) {
        if (StringUtils.isNullOrBlank(input)) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }
        return calculate(splitTokens(input));
    }

    private static int calculate(List<String> tokens) {
        Queue<String> tokensQueue = new LinkedList<>(tokens);
        int result = removeIntFromQueue(tokensQueue);
        while (!tokensQueue.isEmpty()) {
            String operator = tokensQueue.remove();
            int number = removeIntFromQueue(tokensQueue);
            result = calculate(result, number, operator);
        }
        return result;
    }

    private static int removeIntFromQueue(Queue<String> tokensQueue) {
        return Integer.parseInt(tokensQueue.remove());
    }

    private static List<String> splitTokens(String input) {
        return Arrays.asList(input.split(SPACE));
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
        if (StringUtils.isNullOrBlank(operator)) {
            throw new IllegalArgumentException("연산자가 비어 있습니다.");
        }
        if (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator
                .equals("/")) {
            throw new IllegalArgumentException("사칙 연산만이 가능합니다");
        }
    }
}

package calculator.domain;

import java.util.List;

public class Calculator {

    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    private Calculator() {}

    public static long evaluate(Expression expression) {
        List<Long> terms = expression.getTerms();
        List<String> operators = expression.getOperators();

        long acc = getFirstTerm(terms);
        for (int i = 0; i < operators.size(); i++) {
            acc = calculate(acc, terms.get(i + 1), operators.get(i));
        }

        return acc;
    }

    private static Long getFirstTerm(List<Long> terms) {
        return terms.get(0);
    }

    private static long calculate(long acc, long term, String op) {
        switch (op) {
            case ADD:
                return add(acc, term);
            case SUBTRACT:
                return subtract(acc, term);
            case MULTIPLY:
                return multiply(acc, term);
            case DIVIDE:
                return divide(acc, term);
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자 입니다.");
        }
    }

    private static long add(long num1, long num2) {
        return num1 + num2;
    }

    private static long subtract(long num1, long num2) {
        return num1 - num2;
    }

    private static long multiply(long num1, long num2) {
        return num1 * num2;
    }

    private static long divide(long num1, long num2) {
        return num1 / num2;
    }
}

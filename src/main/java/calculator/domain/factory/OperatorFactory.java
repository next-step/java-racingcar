package calculator.domain.factory;

import calculator.domain.*;

import java.util.HashSet;
import java.util.Set;

public class OperatorFactory {
    private static final String OPERATOR_ADD = "+";
    private static final String OPERATOR_SUBTRACT = "-";
    private static final String OPERATOR_MULTIPLY = "*";
    private static final String OPERATOR_DIVIDE = "/";

    private static final Set<String> OPERATOR = new HashSet<>();

    static {
        OPERATOR.add(OPERATOR_ADD);
        OPERATOR.add(OPERATOR_SUBTRACT);
        OPERATOR.add(OPERATOR_MULTIPLY);
        OPERATOR.add(OPERATOR_DIVIDE);
    }

    public static Operator build(String value) {
        switch (value) {
            case OPERATOR_ADD:
                return new AddOperator();

            case OPERATOR_SUBTRACT:
                return new SubtractOperator();

            case OPERATOR_MULTIPLY:
                return new MultiplyOperator();

            case OPERATOR_DIVIDE:
                return new DivideOperator();

            default:
                throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }

    public static boolean isOperator(String operator) {
        return OPERATOR.contains(operator);
    }

    public static boolean isNotOperator(String operator) {
        return !isOperator(operator);
    }

}

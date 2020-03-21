package calculator.operator;

public class OperatorFactory {
    private final static String OPERATOR_KEYWORD_PLUS = "+";
    private final static String OPERATOR_KEYWORD_MINUS = "-";
    private final static String OPERATOR_KEYWORD_MULTIPLY = "*";
    private final static String OPERATOR_KEYWORD_DIVISION = "/";

    public static Operator getOperator(String operator) {
        if (OPERATOR_KEYWORD_PLUS.equals(operator)) {
            return new PlusOperator();
        }

        if (OPERATOR_KEYWORD_MINUS.equals(operator)) {
            return new MinusOperator();
        }

        if (OPERATOR_KEYWORD_MULTIPLY.equals(operator)) {
            return new MultiplyOperator();
        }

        if (OPERATOR_KEYWORD_DIVISION.equals(operator)) {
            return new DivisionOperator();
        }

        throw new IllegalArgumentException("수식 중 사칙연산 기호가 잘못되었습니다.");
    }
}

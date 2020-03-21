package calculator.operator;

public class OperatorFactory {
    private final static String OPERATOR_KEYWORD_PLUS = "+";
    private final static String OPERATOR_KEYWORD_MINUS = "-";
    private final static String OPERATOR_KEYWORD_MULTIPLY = "*";
    private final static String OPERATOR_KEYWORD_DIVISION = "/";

    public static Operator getOperator(String operatorString) {
        if (OPERATOR_KEYWORD_PLUS.equals(operatorString)) {
            return new PlusOperator();
        }

        if (OPERATOR_KEYWORD_MINUS.equals(operatorString)) {
            return new MinusOperator();
        }

        if (OPERATOR_KEYWORD_MULTIPLY.equals(operatorString)) {
            return new MultiplyOperator();
        }

        if (OPERATOR_KEYWORD_DIVISION.equals(operatorString)) {
            return new DivisionOperator();
        }

        return null;
    }
}

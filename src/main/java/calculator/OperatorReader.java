package calculator;

public class OperatorReader {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final PlusOperator plusOperator = new PlusOperator();
    private static final MinusOperator minusOperator = new MinusOperator();
    private static final MultiplyOperator multiplyOperator = new MultiplyOperator();
    private static final DivideOperator divideOperator = new DivideOperator();

    public Operator readOperator(String operator) {
        if(PLUS.equals(operator)) {
            return plusOperator;
        }

        if(MINUS.equals(operator)) {
            return minusOperator;
        }

        if(MULTIPLY.equals(operator)) {
            return multiplyOperator;
        }

        if(DIVIDE.equals(operator)) {
            return divideOperator;
        }
        throw new IllegalArgumentException();
    }
}

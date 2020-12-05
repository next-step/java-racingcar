package calculator;

public class OperatorReader {
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DEVIDE = "/";

    public Operator readOperator(String operator) {
        if(PLUS.equals(operator)) {
            return new PlusOperator();
        }

        if(MINUS.equals(operator)) {
            return new MinusOperator();
        }

        if(MULTIPLY.equals(operator)) {
            return new MultiplyOperator();
        }

        if(DEVIDE.equals(operator)) {
            return new DevideOperator();
        }
        throw new IllegalArgumentException();
    }
}

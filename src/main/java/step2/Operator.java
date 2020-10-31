package step2;

public class Operator implements ExpressionFactor {

    private final char value;
    private OperatorFunction operatorFunction = null;

    public Operator(String factor) {
        char ch = factor.charAt(0);
        operatorFunction = OperatorFunction.of(factor);
        value = ch;
    }

    public char getValue() {
        return value;
    }

    public int operate(int firstFactor, int secondFactor) {
        return operatorFunction.operate(firstFactor, secondFactor);
    }
}

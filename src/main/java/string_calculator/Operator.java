package string_calculator;

public class Operator implements ExpressionFactor {

    private OperatorFunction operatorFunction = null;

    public Operator(String factor) {
        operatorFunction = OperatorFunction.of(factor);
    }

    public int operate(int firstFactor, int secondFactor) {
        return operatorFunction.operate(firstFactor, secondFactor);
    }
}

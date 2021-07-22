package calculator;

public class Calculator {

    public int calculate(String input) {
        return calculate(ArithmeticExpression.of(input));
    }

    private int calculate(ArithmeticExpression arithmeticExpression) {
        int first = arithmeticExpression.hasOnlyOneOperator()
                ? arithmeticExpression.getFirstNumber()
                : calculate(arithmeticExpression.exceptLastOperation());
        int last = arithmeticExpression.getLastNumber();
        Operator operator = arithmeticExpression.getLastOperator();
        return operator.operate(first, last);
    }

}

package calculator;

public class Calculator {

    public int calculate(String input) {
        ArithmeticExpression arithmeticExpression = ArithmeticExpression.of(input);
        int first = arithmeticExpression.hasOnlyOneOperator()
                ? arithmeticExpression.getFirstNumber()
                : calculate(arithmeticExpression.exceptLastOperation());
        int last = arithmeticExpression.getLastNumber();
        Operator operator = arithmeticExpression.getLastOperator();
        return operator.operate(first, last);
    }

}

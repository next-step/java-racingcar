package calculator;

public class Calculator {

    private Calculator() {
    }

    public static Number calculate(String inputText, NumberType numberType) {
        Expression expression = new Expression(inputText, numberType);

        Number result = expression.getNextNumber();

        while (expression.hasElement()) {
            result = expression.getNextOperator().calculate(result, expression.getNextNumber());
        }

        return result;
    }
}

package calculator;

public class Calculator {
    public static int calculate(String expression) {
        Polynomial polynomial = Polynomial.createPolynomialWithExpression(expression);
        return polynomial.calculate();
    }
}

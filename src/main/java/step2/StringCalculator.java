package step2;

public class StringCalculator {
    public static CalculatorNumber calculate(String expression) {
        return Expression.from(expression).compute();
    }
}

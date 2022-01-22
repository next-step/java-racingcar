package calculator.domain.calculator;


public class CalculatorFactory {

    public CalculatorFactory() {
    }

    public double get(CalculatorStrategy operatorStrategy, double num1, double num2) {
        return operatorStrategy.apply(num1, num2);
    }
}

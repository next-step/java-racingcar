package calculator.domain.calculator;

public class Subtraction implements CalculatorStrategy {

    @Override
    public double apply(double num1, double num2) {
        return num1 - num2;
    }
}
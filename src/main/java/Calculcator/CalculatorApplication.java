package Calculcator;

import Calculcator.domain.Calculator;

public class CalculatorApplication {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        double result = calculator.calculation("2 + 4 / 3 * 5");

        System.out.println(result);
    }
}

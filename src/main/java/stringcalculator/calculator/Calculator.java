package stringcalculator.calculator;

import stringcalculator.Expression;

public class Calculator {

    private static final String ADDITION = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "+";
    private static final String DIVISION = "+";

    Calculator() {
    }

    public static Calculator getInstance() {
        return new Calculator();
    }

    public int calculate(Expression expression) {
        return 0;
    };

}

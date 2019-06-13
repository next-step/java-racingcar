package calculate;

import java.util.function.BinaryOperator;

public enum Calculator {
    ADDITION((number1, number2) -> number1 + number2),
    SUBTRACTION((number1, number2) -> number1 - number2),
    DIVISION((number1, number2) -> number1 / number2),
    MULTIPLICATION((number1, number2) -> number1 * number2);
    
    private BinaryOperator<Integer> calculator;
    
    Calculator(BinaryOperator<Integer> calculator) {
        this.calculator = calculator;
    }
    
    public int calculate(int number1, int number2) {
        return this.calculator.apply(number1, number2);
    }
}

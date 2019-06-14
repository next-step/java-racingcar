package calculate;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public enum Calculator {
    ADDITION("+", (number1, number2) -> number1 + number2),
    SUBTRACTION("-", (number1, number2) -> number1 - number2),
    DIVISION("/", (number1, number2) -> number1 / number2),
    MULTIPLICATION("-", (number1, number2) -> number1 * number2);
    
    private BinaryOperator<Integer> calculator;
    private String mathSign;
    
    Calculator(String mathSign, BinaryOperator<Integer> calculator) {
        this.calculator = calculator;
        this.mathSign = mathSign;
    }
    
    public int calculate(int number1, int number2) {
        return calculator.apply(number1, number2);
    }
    
    public static Calculator getMathSign(String sign) {
        Calculator[] calculators = Calculator.values();
        Stream<Calculator> result = Arrays.stream(calculators)
            .filter(calculator -> {
                String mathSign = calculator.mathSign;
                return mathSign.equals(sign); 
            });
        
        if (result.count() == 0) {
            throw new IllegalArgumentException();
        }
        return result.findFirst().get();
    }
}

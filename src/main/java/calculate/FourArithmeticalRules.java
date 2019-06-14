package calculate;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public enum FourArithmeticalRules {
    ADDITION("+", (number1, number2) -> number1 + number2),
    SUBTRACTION("-", (number1, number2) -> number1 - number2),
    DIVISION("/", (number1, number2) -> number1 / number2),
    MULTIPLICATION("*", (number1, number2) -> number1 * number2);
    
    private BinaryOperator<Integer> calculator;
    private String mathSign;
    
    FourArithmeticalRules(String mathSign, BinaryOperator<Integer> calculator) {
        this.calculator = calculator;
        this.mathSign = mathSign;
    }
    
    public int calculate(int number1, int number2) {
        return calculator.apply(number1, number2);
    }
    
    public static FourArithmeticalRules getMathSign(String sign) {
        if (!FourArithmeticalRules.hasMathSign(sign)) {
            throw new IllegalArgumentException();
        }
        
        FourArithmeticalRules[] arithmeticalRules = FourArithmeticalRules.values();
        Stream<FourArithmeticalRules> result = Arrays.stream(arithmeticalRules)
            .filter(arithmeticalRule -> sign.equals(arithmeticalRule.mathSign));
        
        return result.findFirst().get();
    }
    
    public static boolean hasMathSign(String sign) {
        FourArithmeticalRules[] arithmeticalRules = FourArithmeticalRules.values();
        return Arrays.stream(arithmeticalRules)
            .anyMatch(arithmeticalRule -> 
                sign.equals(arithmeticalRule.mathSign)
            );
    }
}

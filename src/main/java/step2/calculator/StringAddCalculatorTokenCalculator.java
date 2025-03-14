package step2.calculator;

public class StringAddCalculatorTokenCalculator {

    public static int sum(StringAddCalculatorToken[] tokens) {
        int result = 0;
        for (StringAddCalculatorToken stringAddCalculatorToken : tokens) {
            result += stringAddCalculatorToken.toInteger();
        }
        return result;
    }
}

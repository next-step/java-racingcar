package calculator;

public class StringCalculator {

    private final static int EMPTY_RESULT = 0;

    public int sum(String str) {
        if (str == null || str.isEmpty()) {
            return EMPTY_RESULT;
        }

        Calculator calculator = CalculatorFactory.calculator(str);

        return calculator.sum(str);
    }
}

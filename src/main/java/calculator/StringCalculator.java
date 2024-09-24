package calculator;

public class StringCalculator {

    public int sum(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        Calculator calculator = CalculatorFactory.calculator(str);

        return calculator.sum(str);
    }
}

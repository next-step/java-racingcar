package Calculator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StringCalculationExecutor {
    private static final Map<String, Calculator> stringCalculator = new HashMap<>();
    private static final Map<String, Calculator> unmodifiableStringCalculator = Collections.unmodifiableMap(stringCalculator);


    static {
        stringCalculator.put("+", new Plus());
        stringCalculator.put("-", new Subtract());
        stringCalculator.put("*", new Multiply());
        stringCalculator.put("/", new Division());
    }

    private static int executeCalculation(String operator, int number1, int number2) {
        Calculator calculator = unmodifiableStringCalculator.get(operator);
        return calculator.calculate(number1, number2);
    }

    public int stringCalculator(String[] numberAndOperator) {
        int result = 0;

        for (int i = 0; i <= numberAndOperator.length / 2 + 2; i += 2) {
            if (result == 0) {
                result = executeCalculation(numberAndOperator[i + 1], Integer.parseInt(numberAndOperator[i]), Integer.parseInt(numberAndOperator[i + 2]));
                continue;
            }
            result = executeCalculation(numberAndOperator[i + 1], result, Integer.parseInt(numberAndOperator[i + 2]));
        }
        return result;
    }
}

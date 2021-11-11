package calculator;

import java.util.Objects;

public class Calculator {

    private static final Integer ZERO = 0;
    private static final Integer INDEX_INTERVAL = 2;

    private Calculator() {
    }

    public static int calculate(String input) {
        String[] arr = FormulaSplitter.split(input);
        int sum = Integer.parseInt(arr[ZERO]);

        for (int i = 1; i < arr.length; i += INDEX_INTERVAL) {
            sum = calculator(sum , arr[i], Integer.parseInt(arr[i + 1]));
        }
        return sum;
    }

    private static int calculator(int firstOperand, String operator, int secondOperand) {
        return Operator.of(operator).operate(firstOperand, secondOperand);
    }
}

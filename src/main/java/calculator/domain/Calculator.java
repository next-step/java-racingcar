package calculator.domain;

import java.util.List;

public class Calculator {
    private static final int FIRST_NUMBER = 0;
    private static final int FIRST_OPERATOR = 1;
    private static final int STEP_OF_OPERATOR = 2;

    private static Calculator instance = new Calculator();

    private Calculator() {
    }

    public static Calculator getInstance() {
        return instance;
    }

    public int calculate(List<String> parsedInput) {
        int total = Integer.parseInt(parsedInput.get(FIRST_NUMBER));
        int inputSize = parsedInput.size();
        for (int i = FIRST_OPERATOR; i < inputSize; i += STEP_OF_OPERATOR) {
            String operator = parsedInput.get(i);
            int nextNumber = Integer.parseInt(parsedInput.get(i+1));
            total = operate(operator, total, nextNumber);
        }
        return total;
    }

    private int operate(String operator, int prevNumber, int nextNumber) {
        return Operator.getType(operator).operate(prevNumber, nextNumber);
    }
}

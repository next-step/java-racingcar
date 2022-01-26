package calculator.domain;

import static calculator.domain.Constants.*;

public class Expression {

    private final String[] userInput;

    public Expression(String[] userInput) {
        this.userInput = userInput;
    }

    public long decomposition() {
        long acc = Long.parseLong(this.userInput[0]);

        for (int i = 1; i < this.userInput.length - 1; i += 2) {
            String operator = this.userInput[i];
            long term = Long.parseLong(this.userInput[i + 1]);

            acc = interpreter(acc, term, operator);
        }
        return acc;
    }

    private static long interpreter(long acc, long term, String operator) {
        switch (operator) {
            case ADD:
                return Calculator.add(acc, term);
            case SUBTRACT:
                return Calculator.subtract(acc, term);
            case MULTIPLY:
                return Calculator.multiply(acc, term);
            case DIVIDE:
                return Calculator.divide(acc, term);
        }
        return 0;
    }
}

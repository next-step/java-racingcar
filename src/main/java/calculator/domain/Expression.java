package calculator.domain;

public class Expression {

    protected static final String OPERATORS = "+-*/";
    private static final int FIRST_TARGET_VALUE = 0;
    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    private String[] userInput;

    public Expression(String[] userInput) {
        this.userInput = userInput;
    }

    public long evaluate() {
        long acc = Long.parseLong(this.userInput[FIRST_TARGET_VALUE]);

        for (int i = 1; i < this.userInput.length - 1; i += 2) {
            String op = this.userInput[i];
            long term = Long.parseLong(this.userInput[i + 1]);

            acc = interpreter(acc, term, op);
        }
        return acc;
    }

    private static long interpreter(long acc, long term, String op) {
        switch (op) {
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

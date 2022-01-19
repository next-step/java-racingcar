package calculator.domain;

public class Expression {

    protected static final String OPERATORS = "+-*/";
    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String MUL = "*";
    private static final String DIV = "/";

    private String[] userInput;

    public Expression(String[] userInput) {
        this.userInput = userInput;
    }

    public long evaluate() {
        long acc = Long.parseLong(this.userInput[0]);

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
            case SUB:
                return Calculator.sub(acc, term);
            case MUL:
                return Calculator.mul(acc, term);
            case DIV:
                return Calculator.div(acc, term);
        }
        return 0;
    }
}

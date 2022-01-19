package calculator.domain;

public class Expression {

    private Expression() {}

    protected static final String OPERATORS = "+-*/";
    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String MUL = "*";
    private static final String DIV = "/";

    public static long evaluate(String[] userInput) {
        long acc = Long.parseLong(userInput[0]);

        for (int i = 1; i < userInput.length - 1; i += 2) {
            String op = userInput[i];
            long term = Long.parseLong(userInput[i + 1]);

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

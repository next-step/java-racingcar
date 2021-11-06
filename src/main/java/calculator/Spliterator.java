package calculator;

public class Spliterator {
    private final String BLANK_REGEX = "\\s+";
    private final String ARITHMETIC_OPERATIONS = "+-*/";
    private final String NUMERIC_REGEX = "[0-9.]+";
    private final int EMPTY_LENGTH = 0;
    private final int OPERATOR_LENGTH = 1;

    private final String[] arguments;
    private int currentIndex;

    public Spliterator(String operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation must not be null");
        }

        this.arguments = operation.split(BLANK_REGEX);
        this.currentIndex = 0;

        if (arguments.length == EMPTY_LENGTH) {
            throw new IllegalArgumentException("Operation must not be blank");
        }
    }

    public Object next() {
        if (currentIndex >= arguments.length) {
            return null;
        }

        String str = arguments[currentIndex++];

        if (isOperator(str)) {
            return Operator.of(str);
        }

        if (isOperand(str)) {
            return new Num(str);
        }

        throw new IllegalArgumentException("Only Number and Arithmetic Operation are allowed.");
    }

    private boolean isOperator(String str) {
        return str != null && str.length() == OPERATOR_LENGTH && ARITHMETIC_OPERATIONS.contains(str);
    }

    private boolean isOperand(String str) {
        return str != null && str.matches(NUMERIC_REGEX);
    }
}

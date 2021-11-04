package calculator;

public class Spliterator {
    private final String[] arguments;
    private int currentIndex;

    public Spliterator(String operation) {
        if (operation == null)
            throw new IllegalArgumentException("Operation must not be null");

        this.arguments = operation.split("\\s+");
        this.currentIndex = 0;

        if (arguments.length == 0)
            throw new IllegalArgumentException("Operation must not be blank");
    }

    public Object next() {
        if (currentIndex >= arguments.length)
            return null;

        String str = arguments[currentIndex++];

        if (isOperator(str))
            return Operator.of(str);

        if (isOperand(str))
            return new Num(str);

        throw new IllegalArgumentException("Only Number and Arithmetic Operation are allowed.");
    }

    private boolean isOperator(String str) {
        return str != null && str.length() == 1 && "+-*/".contains(str);
    }

    private boolean isOperand(String str) {
        return str != null && str.matches("[0-9.]+");
    }
}

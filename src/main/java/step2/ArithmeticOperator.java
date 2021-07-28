package step2;

public enum ArithmeticOperator {
    PLUS("+")     { @Override long operate(long num1, long num2) { return num1 + num2; } },
    MINUS("-")    { @Override long operate(long num1, long num2) { return num1 - num2; } },
    MULTIPLY("*") { @Override long operate(long num1, long num2) { return num1 * num2; } },
    DIVIDE("/")   { @Override long operate(long num1, long num2) { return num1 / num2; } };

    private static final ArithmeticOperator[] ARITHMETIC_OPERATORS_ARRAY = ArithmeticOperator.values();
    private final String symbol;

    ArithmeticOperator(String symbol) { this.symbol = symbol; }

    public String getSymbol() { return symbol; }

    public static ArithmeticOperator of(String symbol) {
        for (ArithmeticOperator operator : ARITHMETIC_OPERATORS_ARRAY) {
            if (operator.getSymbol().equals(symbol))
                return operator;
        }
        throw new IllegalArgumentException();
    }

    abstract long operate(long num1, long num2);
}

package calculator;

public enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }


    public static Operator findBySymbol(String symbol) {

        for (Operator value : values()) {
            if (value.symbol.equals(symbol)) {
                return value;
            }
        }
        throw new IllegalArgumentException("[ERROR] 연산자는 +, -, * , / 만 가능합니다.");
    }
}


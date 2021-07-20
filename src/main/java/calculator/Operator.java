package calculator;

public enum Operator {

    PLUS("+"){
        int exec(int num1, int num2) {
            return num1 + num2;
        }
    },
    MINUS("-"){
        int exec(int num1, int num2) {
            return num1 - num2;
        }
    },
    MULTIPLY("*"){
        int exec(int num1, int num2) {
            return num1 * num2;
        }
    },
    DIVIDE("/"){
        int exec(int num1, int num2) {
            return num1 / num2;
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    abstract int exec(int num1, int num2);

    public static Operator of(String symbol) {
        Operator[] operators = Operator.values();
        for (Operator operator : operators) {
            if(operator.getSymbol().equals(symbol)){
                return operator;
            }
        }
        throw new IllegalArgumentException("Invalid value : " + symbol);
    }
}

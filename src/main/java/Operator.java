import java.util.function.BiFunction;

enum Operator {
    PLUS("+", (n1, n2) -> n1 + n2),
    MINUS("-", (n1, n2) -> n1 - n2),
    MULTIPLY("*", (n1, n2) -> n1 * n2),
    DIVIDE("/", (n1, n2) -> n1 / n2);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> operation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation){
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public int operate(int n1, int n2){
        return operation.apply( n1, n2);
    }

}
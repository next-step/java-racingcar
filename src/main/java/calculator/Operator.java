package calculator;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> operation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol(){
        return symbol;
    }

    public int operate(int num1, int num2){
        return operation.apply(num1, num2);
    }

}

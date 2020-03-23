package calculator;

import java.util.Objects;
import java.util.function.BiFunction;

public class Token {

    private String operation = "";
    private Integer operand = 0;
    private BiFunction<Integer, Integer, Integer> func = null;

    public Token(String operation, int operand) {
        this.operation = operation;
        this.operand = operand;
        this.func = getOperation();
    }

    public int calculate(int number) {
        return func.apply(number, operand);
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Token)) {
            return false;
        }
        Token target = (Token) o;
        return operation.equals(target.operation) && operand == target.operand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, operand);
    }

    private BiFunction<Integer, Integer, Integer> getOperation() {
        switch (operation) {
            case "-":
                return (BiFunction<Integer, Integer, Integer>) (a, b) -> a - b;
            case "*":
                return (BiFunction<Integer, Integer, Integer>) (a, b) -> a * b;
            case "/":
                return (BiFunction<Integer, Integer, Integer>) (a, b) -> a / b;
            case "+":
                return (BiFunction<Integer, Integer, Integer>) (a, b) -> a + b;
            default:
                throw new RuntimeException("지정되지 않은 연산자");
        }
    }
}

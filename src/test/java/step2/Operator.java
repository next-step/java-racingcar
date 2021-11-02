package step2;

import java.util.function.BinaryOperator;

public class Operator {

    private final BinaryOperator<Integer> binaryOperator;

    private Operator(BinaryOperator<Integer> binaryOperator) {
        this.binaryOperator = binaryOperator;
    }

    public static Operator from(String operator) {
        BinaryOperator<Integer> binaryOperator;
        switch (operator) {
            case "+":
                binaryOperator = (left, right) -> left + right;
                break;
            case "-":
                binaryOperator = (left, right) -> left - right;
                break;
            case "*":
                binaryOperator = (left, right) -> left * right;
                break;
            case "/":
                binaryOperator = (left, right) -> left / right;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        return new Operator(binaryOperator);
    }

    public BinaryOperator<Integer> getBinaryOperator() {
        return binaryOperator;
    }
}

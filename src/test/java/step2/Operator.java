package step2;

import java.util.function.BinaryOperator;

public class Operator {

    private final BinaryOperator<Integer> binaryOperator;

    private Operator(BinaryOperator<Integer> binaryOperator) {
        this.binaryOperator = binaryOperator;
    }

    public static Operator from(String operator) {
        BinaryOperator<Integer> binaryOperator;
        //TODO switch - case 로직을 삭제 할 좋은 방법은 없을까요?!
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

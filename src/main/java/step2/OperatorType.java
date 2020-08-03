package step2;

import java.util.Arrays;

public enum OperatorType {

    PLUS("+", (leftOperand, rightOperand) -> leftOperand + rightOperand),
    SUBTRACT("-", (leftOperand, rightOperand) -> leftOperand - rightOperand),
    MULTIPLY("*", (leftOperand, rightOperand) -> leftOperand * rightOperand),
    DIVIDE("/", (leftOperand, rightOperand) -> leftOperand / rightOperand)
    ;

    private String symbol;
    private Operator operator;

    OperatorType(String symbol, Operator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public int operate(int leftOperand, int rightOperand) {
        return operator.operate(leftOperand, rightOperand);
    }

    public static OperatorType findBySymbol(String symbol) {
        return Arrays.stream(OperatorType.values())
                .filter(operatorType -> operatorType.symbol.equals(symbol))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

}

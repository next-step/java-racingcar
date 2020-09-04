package mission1.step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorType {
    PLUS("+", (firstOperand, secondOperand) ->  firstOperand + secondOperand),
    MINUS("-", (firstOperand, secondOperand) -> firstOperand - secondOperand),
    MULTIPLY("*", (firstOperand, secondOperand) -> firstOperand * secondOperand),
    DIVIDE("/", (firstOperand, secondOperand) -> firstOperand / secondOperand);

    private String operator;
    private BiFunction<Integer, Integer, Integer> operation;

    OperatorType (String operator, BiFunction<Integer, Integer, Integer> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public static OperatorType searchOperation(String operator) {
        return Arrays.stream(OperatorType.values())
                .filter((opType) -> operator.equals(opType.getOperator()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("인자값이 연산자 문자열이 아닙니다."));
    }

    public Integer calculate(Integer firstOperand, Integer secondOperand) {
        return operation.apply(firstOperand, secondOperand);
    }

    private String getOperator() {
        return operator;
    }
}



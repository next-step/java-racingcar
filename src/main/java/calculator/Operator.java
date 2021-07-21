package calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (operand1, operand2) -> operand1 + operand2),
    MINUS("-", (operand1, operand2) -> operand1 - operand2),
    DIV("/", (operand1, operand2) -> operand1 / operand2),
    MUL("*", (operand1, operand2) -> operand1 * operand2);

    private final String sign;
    private final BinaryOperator<Integer> operation;


    Operator(String sign, BinaryOperator<Integer> operation) {
        this.sign = sign;
        this.operation = operation;
    }

    public static Operator find(String sign) {
        return Arrays.asList(Operator.values())
                .stream()
                .filter(o -> o.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효한 연산자 형식이 아닙니다."));
    }

    public static int operation(String sign, int operand1, int operand2){
        Operator operator = find(sign);

        if(operator.equals(DIV) && operand2 == 0){
            throw new IllegalArgumentException("나눗셈은 0으로 연산할 수 없습니다.");
        }

        return operator.operation.apply(operand1,operand2);

    }


}

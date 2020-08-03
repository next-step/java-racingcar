package step2.calculator;

import step2.common.ExceptionMessage;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operation implements IntBinaryOperator{
    CALC_ADD("+", (num1, num2) -> num1 + num2),
    CALC_SUBTRACT("-", (num1, num2) -> num1 - num2),
    CALC_MULTIPLY("*", (num1, num2) -> num1 * num2),
    CALC_DIVIDE("/", (num1, num2) -> {
        if(num2 == 0) {
            throw new ArithmeticException(ExceptionMessage.DIVIDE_VALUE_IS_ZERO);
        }
        return num1 / num2;
    });

    private final IntBinaryOperator binaryOperator;
    private String input;

    Operation(String input, IntBinaryOperator binaryOperator) {
        this.input = input;
        this.binaryOperator = binaryOperator;
    }

    // 두 개의 int 연산 ex) "+".applyAsInt(1,2) -> 3
    public int applyAsInt(int num1, int num2){
        return binaryOperator.applyAsInt(num1, num2);
    }

    /** Stream API 공부 필요 **/
    // 연산자 찾기
    public static Operation findOperation(String str){
        return Arrays.stream(values())
                .filter(s -> s.input.equals(str))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException(ExceptionMessage.SYMBOL_NOT_ARITHMETIC));
    }


}

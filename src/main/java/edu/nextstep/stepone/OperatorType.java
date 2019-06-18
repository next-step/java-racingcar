package edu.nextstep.stepone;

import java.util.Arrays;
import java.util.function.BinaryOperator;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-14 16:21
 */
public enum OperatorType {
    SUM("+", (firstNumber, secondNumber) -> firstNumber + secondNumber),
    MINUS("-", (firstNumber, secondNumber) -> firstNumber - secondNumber),
    MUTIPLY("*", (firstNumber, secondNumber) -> firstNumber * secondNumber),
    DIVIDED("/", (firstNumber, secondNumber) -> firstNumber / secondNumber);

    private String type;
    private BinaryOperator<Integer> oper;

    OperatorType(String type, BinaryOperator<Integer> oper) {
        this.type = type;
        this.oper = oper;
    }

    public String getType() {
        return this.type;
    }

    public static OperatorType typeCheck(String operator) {
        OperatorType[] operatorType = OperatorType.values();
        return Arrays.stream(operatorType)
                .filter(oper -> oper.type.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("입력하신 Type은 연산자가 아닙니다 [" + operator + "]"));
    }

    public int calculate(int firstNumber, int secondNumber) {
        return oper.apply(firstNumber, secondNumber);
    }
}
package com.kakao.calculator.domain;

import java.util.Arrays;

public enum Operator {

    PLUS("+", Operand::plus),
    MINUS("-", Operand::minus),
    MULTIPLE("*", Operand::multiple),
    DIVIDE("/", Operand::divide);

    private final String value;
    private final OperatorProcess operatorProcess;

    Operator(String value, OperatorProcess operatorProcess) {
        this.value = value;
        this.operatorProcess = operatorProcess;
    }

    @FunctionalInterface
    public interface OperatorProcess {
        Operand process(Operand num1, Operand num2);
    }

    public static Operator of(String input) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.value.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 연산자 입니다."));
    }

    public Operand operation(Operand leftOperand, Operand rightOperand) {
        return this.operatorProcess.process(leftOperand, rightOperand);
    }

}

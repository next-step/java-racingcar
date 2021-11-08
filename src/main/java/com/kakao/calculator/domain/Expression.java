package com.kakao.calculator.domain;

public class Expression {

    private final String[] tokens;

    public Expression(String[] tokens) {
        if (tokens.length % 2 == 0){
            throw new IllegalArgumentException("올바르지 않은 식 입니다.");
        }
        this.tokens = tokens;
    }

    public Operand execute() {
        Operand leftOperand = Operand.of(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            Operator operator = Operator.of(tokens[i]);
            Operand rightOperand = Operand.of(tokens[i + 1]);
            leftOperand = operator.operation(leftOperand, rightOperand);
        }
        return leftOperand;
    }
}

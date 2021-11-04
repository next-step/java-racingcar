package com.kakao.calculator.domain;

import java.util.Objects;

public class Operand {
    private final double value;

    Operand(double value) {
        this.value = value;
    }

    public static Operand of(String input) {
        try{
            return new Operand(Double.parseDouble(input));
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("올바르지 않은 피연산자 타입입니다.");
        }
    }

    Operand plus(Operand rightOperand) {
        return new Operand(value + rightOperand.value);
    }

    Operand minus(Operand rightOperand) {
        return new Operand(value - rightOperand.value);
    }

    Operand multiple(Operand rightOperand) {
        return new Operand(value * rightOperand.value);
    }

    Operand divide(Operand rightOperand) {
        if (rightOperand.value == 0)
            throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
        return new Operand(value / rightOperand.value);
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand = (Operand) o;
        return Double.compare(operand.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

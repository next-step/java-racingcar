package com.jaeyeonling.calculator;

import com.jaeyeonling.calculator.type.Operator;

public class Calculator {

    public int add(int a, int b) {
        return Operator.ADD.apply(a, b);
    }

    public int subtract(int a, int b) {
        return Operator.SUBTRACT.apply(a, b);
    }

    public int multiply(int a, int b) {
        return Operator.MULTIPLY.apply(a, b);
    }

    public int divide(int a, int b) {
        return Operator.DIVIDE.apply(a, b);
    }
}

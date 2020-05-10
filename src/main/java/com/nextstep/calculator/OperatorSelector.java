package com.nextstep.calculator;

public class OperatorSelector {
    public static Operator select(String stringValue) {
        if ("+".equals(stringValue)) {
            return Operator.PLUS;
        }
        if ("-".equals(stringValue)) {
            return Operator.MINUS;
        }
        if ("*".equals(stringValue)) {
            return Operator.MULTIPLY;
        }
        if ("/".equals(stringValue)) {
            return Operator.DIVIDE;
        }
        throw new IllegalArgumentException();
    }
}

package com.nextstep.calculator;

public class OperatorSelector {
    public static Operator select(String stringValue) {
        if (stringValue.equals("+")) {
            return Operator.PLUS;
        }
        if (stringValue.equals("-")) {
            return Operator.MINUS;
        }
        if (stringValue.equals("*")) {
            return Operator.MULTIPLY;
        }
        if (stringValue.equals("/")) {
            return Operator.DIVIDE;
        }
        throw new IllegalArgumentException();
    }
}

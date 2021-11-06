package com.process;

import com.util.ArithmeticOperation;

public class InputProcessor {

    public int calculate(char[] arr) {

        return 10;
    }

    public int subCalculate(int target, char operator, int source) {
        ArithmeticOperation oper = new ArithmeticOperation();

        switch (operator) {
            case '+' :
                return oper.plus(target, source);
            case '-' :
                return oper.minus(target, source);
            case '*' :
                return oper.multiply(target, source);
            case '/' :
                return oper.divide(target, source);
        }

        return -1;
    }
}

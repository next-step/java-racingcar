package com.process;

import com.util.ArithmeticOperation;

public class InputProcessor {

    public int calculate(String request) {
        String[] arr = request.split(" ");
        int first = Integer.valueOf(arr[0]);

        for (int idx = 1; idx < arr.length; idx += 2) {
            first = subCalculate(first, arr[idx], Integer.valueOf(arr[idx + 1]));
        }

        return first;
    }

    public int subCalculate(int target, String operator, int source) {
        ArithmeticOperation oper = new ArithmeticOperation();

        switch (operator) {
            case "+" :
                return oper.plus(target, source);
            case "-" :
                return oper.minus(target, source);
            case "*" :
                return oper.multiply(target, source);
            case "/" :
                return oper.divide(target, source);
        }

        return -1;
    }
}

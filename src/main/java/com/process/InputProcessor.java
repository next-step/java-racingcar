package com.process;

import com.util.ArithmeticOperation;

public class InputProcessor {
    private final String DELIMITER = " ";

    public int calculate(String request) {
        if (request == null || request.isEmpty())  throw new IllegalArgumentException("문자열이 알맞지 않습니다");

        String[] arr = request.split(DELIMITER);
        int result = Integer.valueOf(arr[0]);

        for (int idx = 1; idx < arr.length; idx += 2) {
            result = subCalculate(result, arr[idx], Integer.valueOf(arr[idx + 1]));
        }

        return result;
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
            default:
                throw new IllegalArgumentException("연산자가 알맞지 않습니다");
        }
    }
}

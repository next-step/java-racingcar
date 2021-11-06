package com.process;

import com.util.ArithmeticOperation;

public class CaculateProcessor {
    private final String DELIMITER = " ";

    public int calculate(String request) {
        if (request == null || request.isEmpty())  throw new IllegalArgumentException("문자열이 알맞지 않습니다");

        String[] units = request.split(DELIMITER);
        int result = Integer.valueOf(units[0]);

        for (int idx = 1; idx < units.length; idx += 2) {
            result = subCalculate(result, units[idx], Integer.valueOf(units[idx + 1]));
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

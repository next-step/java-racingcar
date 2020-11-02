package calculator;

import java.util.HashMap;
import java.util.Map;

public enum Operator {

    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIVIDE("/");

    private static class Types {
        static Map<String, Operator> operators = new HashMap<>();
    }

    Operator(String op) {
        Types.operators.put(op,this);
    }

    private static Operator validationCheck(String operator) {
        Operator operatorType = Operator.Types.operators.get(operator);
        if(operatorType == null) {
            throw new IllegalArgumentException("정의된 연산기호가 아닙니다");
        }
        return operatorType;
    }

    public static int operation(int n1, int n2, String operator) {
        if(validationCheck(operator).equals(PLUS)) {
            return n1 + n2;
        }
        if(validationCheck(operator).equals(MINUS)) {
            return n1 - n2;
        }
        if(validationCheck(operator).equals(TIMES)) {
            return n1 * n2;
        }
        if(validationCheck(operator).equals(DIVIDE)) {
            if(n2 <= 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다");
            }
            return n1 / n2;
        }
        throw new IllegalArgumentException("정의된 연산기호가 아닙니다");
    }

}

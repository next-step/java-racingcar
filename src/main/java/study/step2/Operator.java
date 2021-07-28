package study.step2;

import java.util.Arrays;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    DEVISION("/");

    String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    static boolean isOperator(String str) {
        return Arrays.stream(Operator.values()).anyMatch(v -> v.operator.equals(str));
    }

    int calculate(int firstNum, int secondNum) {

        int result = 0;


        /*
         * else 사용 코드
         * */
        if (operator.equals(Operator.PLUS.operator)) {
            result = firstNum + secondNum;
        } else if (operator.equals(Operator.MINUS.operator)) {
            result = firstNum - secondNum;
        } else if (operator.equals(Operator.MULTIPLICATION.operator)) {
            result = firstNum * secondNum;
        } else if (operator.equals(Operator.DEVISION.operator)) {
            result = firstNum / secondNum;
        }


        /*
        * else 미사용 코드
        * */
        if (operator.equals(Operator.PLUS.operator)) {
            return firstNum + secondNum;
        }

        if (operator.equals(Operator.MINUS.operator)) {
            return firstNum - secondNum;
        }

        if (operator.equals(Operator.MULTIPLICATION.operator)) {
            return firstNum * secondNum;
        }

        if (operator.equals(Operator.DEVISION.operator)) {
            return firstNum / secondNum;
        }

        return result;
    }


    static Operator valueOfStr(String str) {
        return Arrays.stream(Operator.values())
                .filter(v -> v.operator.equals(str))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

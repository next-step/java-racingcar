package calculator;

public class Calculator {

    public static int calculate(int result, int number, String sign) {
        if(sign.equals("+")) {
            return add(result, number);
        }
        if(sign.equals("*")) {
            return multiply(result, number);
        }
        if(sign.equals("-")) {
            return minus(result, number);
        }
        if(sign.equals("/")) {
            return divide(result, number);
        }

        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }

    private static int divide(int result, int number) {
        return result/number;
    }

    private static int minus(int result, int number) {
        return result-number;
    }

    private static int multiply(int result, int number) {
        return result*number;
    }

    private static int add(int result, int number) {
        return result+number;
    }
}

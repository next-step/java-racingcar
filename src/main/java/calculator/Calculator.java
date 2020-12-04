package calculator;

public class Calculator {

    public static long calculate(long left, long right, String operator) {
        return Operator.calculate(left, right, operator);
    }

}

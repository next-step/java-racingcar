package calculator.domain;

public class Calculator {

    public static long calculate(long left, long right, String symbol) {
        return Operator.calculate(left, right, symbol);
    }

}

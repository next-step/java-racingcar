package calculator.domain;

import calculator.util.Utils;

public class Expression {

    public static final String REGEX = " ";

    public static long execute(String expression) {
        Utils.checkNullOrEmpty(expression);
        String[] strings = expression.split(REGEX);
        long left = Utils.stringToLong(strings[0]);
        for (int i = 0; i < strings.length - 1; i += 2) {
            String symbol = strings[i + 1];
            long right = Utils.stringToLong(strings[i + 2]);
            left = Calculator.calculate(left, right, symbol);
        }
        return left;
    }

}

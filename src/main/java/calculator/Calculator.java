package calculator;

import java.util.Arrays;

public class Calculator {

    public static final String COMMA = ",";
    public static final String COLUMN = ":";

    public long calculate(String value) {
        if (containsComma(value)) {
            return calculateSum(value, COMMA);
        }
        return calculateSum(value, COLUMN);
    }

    private boolean containsComma(String value) {
        return value.contains(",");
    }

    private long calculateSum(String value, String regex) {
        long sum = 0;
        sum += Arrays.stream(value.split(regex)).mapToInt(Integer::parseInt).sum();
        return sum;
    }
}

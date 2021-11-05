package calculator;

import java.util.Arrays;
import java.util.List;

public class Calculate {

    public static String SPLITTER = " ";

    public static int calculate(String str) {

        List<String> a = Arrays.asList(str.split(SPLITTER));
        return splitString(a).getNumber();
    }

    public static Calculator splitString(List<String> items) {

        if (items.size() == 1) {
            return new Calculator(items.get(0));
        }

        List<String> firstList = items.subList(0, items.size() - 2);
        String operator = items.get(items.size() - 2);
        Calculator second = new Calculator(items.get(items.size() - 1));

        return calculate(splitString(firstList), operator, second);
    }

    public static Calculator calculate(Calculator a, String operator, Calculator b) {

        if (operator.equals("+")) {
            return a.plus(b);
        }
        if (operator.equals("-")) {
            return a.minus(b);
        }
        if (operator.equals("*")) {
            return a.multiple(b);
        }
        if (operator.equals("/")) {
            return a.divide(b);
        }

        throw new IllegalArgumentException("Illegal operator");
    }
}



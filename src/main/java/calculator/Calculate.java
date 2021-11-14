package calculator;

import java.util.Arrays;
import java.util.List;

public class Calculate {

    public final static String SPLITTER = " ";

    public int calculate(String str) {

        List<String> list = Arrays.asList(str.split(SPLITTER));
        return splitString(list).getNumber();
    }

    public Calculator splitString(List<String> items) {

        if (items.size() == 1) {
            return new Calculator(Integer.parseInt(items.get(0)));
        }

        List<String> firstList = items.subList(0, items.size() - 2);
        String operator = items.get(items.size() - 2);
        Calculator second = new Calculator(Integer.parseInt(items.get(items.size() - 1)));

        return calculate(splitString(firstList), operator, second);
    }

    public Calculator calculate(Calculator a, String operator, Calculator b) {

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



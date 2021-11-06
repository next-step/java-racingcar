package calculator.ver2;

import java.util.Arrays;
import java.util.List;

public class CalculatorVer2 {

    public static MyNumberVer2 calculatorByMyNumber(String text) {
        List<String> values = Arrays.asList(text.split(" "));

        MyNumberVer2 first = new MyNumberVer2(values.get(0)), second;
        int index = 1;

        while (values.size() > index) {

            String operator = values.get(index++);

            second = new MyNumberVer2(values.get(index++));

            first = calculatorByMyNumber(first, operator, second);
        }

        return first;
    }

    private static MyNumberVer2 calculatorByMyNumber(MyNumberVer2 first, String operator, MyNumberVer2 second) {

        if (operator.equals("+")) {
            return first.plus(second);
        }
        if (operator.equals("-")) {
            return first.minus(second);
        }
        if (operator.equals("*")) {
            return first.multiple(second);
        }
        if (operator.equals("/")) {
            return first.divide(second);
        }

        throw new IllegalArgumentException("사칙연산 기호를 확인하세요");
    }


}

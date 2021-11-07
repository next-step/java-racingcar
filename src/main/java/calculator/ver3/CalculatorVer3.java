package calculator.ver3;

import java.util.Arrays;
import java.util.List;

public class CalculatorVer3 {

    private final static String EMPTY_STRING = " ";
    private final static int ZERO = 0;
    private final static int ONE = 1;


    public static MyNumberVer3 calculatorByMyNumber(String text) {
        List<String> values = Arrays.asList(text.split(EMPTY_STRING));

        MyNumberVer3 first = new MyNumberVer3(values.get(ZERO)), second;
        int index = ONE;

        while (values.size() > index) {

            String operator = values.get(index++);

            second = new MyNumberVer3(values.get(index++));

            first = calculatorByMyNumber2(first, operator, second);
        }

        return first;
    }

    private static MyNumberVer3 calculatorByMyNumber2(MyNumberVer3 first, String operator, MyNumberVer3 seconds) {
        Operation operation = Operation.valueOfString(operator);
        return operation.apply(first, seconds);
    }


}

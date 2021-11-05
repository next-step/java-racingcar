package step2;

import java.util.Objects;

public class Calculator {

    private final static String delimiter = " ";

    private Calculator() {}

    public static int calculate(String input) {
        validText(input);

        String[] values = splitTextByDelimiter(input, delimiter);

        MyNumber number1 = new MyNumber(values[0]);
        String operator = values[1];
        MyNumber number2 = new MyNumber(values[2]);

        return calculate(number1, operator, number2).getNumber();
    }

    public static MyNumber calculateMulti(String input) {
        String[] values = splitTextByDelimiter(input, delimiter);

        int cnt = values.length;

        MyNumber number = new MyNumber(values[0]);

        for(int i = 1 ; i < cnt ; i += 2) {
            String operator = values[i];
            MyNumber number2 = new MyNumber(values[i+1]);

            number = calculate(number, operator, number2);
        }

        return number;
    }

    private static MyNumber calculate(MyNumber number1, String operator, MyNumber number2) {
        if(operator.equals("+")) {
            return number1.plus(number2);
        }
        if(operator.equals("-")) {
            return number1.minus(number2);
        }
        if(operator.equals("*")) {
            return number1.multiply(number2);
        }
        if(operator.equals("/")) {
            return number1.divide(number2);
        }

        throw new IllegalArgumentException(MyException.INVALID_OPERATOR.getMessage());
    }

    public static void validText(String text) {
        if(Common.textNullOrEmpty(text)) {
            throw new IllegalArgumentException(MyException.EMPTY_INPUT.getMessage());
        }
    }

    private static String[] splitTextByDelimiter(String text, String delimiter) {
        return text.split(delimiter);
    }
}

package step2;

import static step2.Validation.VALID_ARITHMETHIC_INPUT_SIZE;
import static step2.Validation.validNullAndEmpty;

public class Calculator {

    public static int calculate(String text) {
        final String[] values = validInputData(text);

        MyNumber first = new MyNumber(values[0]);
        for (int i = 1; i < values.length - 1; i += 2) {
            String operator = values[i];
            MyNumber second = new MyNumber(values[i + 1]);
            first = calculate(first, operator, second);
        }
        return first.number;
    }

    private static String[] validInputData(String text) {
        validNullAndEmpty(text);
        final String[] values = text.split(" ");
        validSize(values);
        return values;
    }

    private static MyNumber calculate(MyNumber first, String operator, MyNumber second) {
        return Operator.of(operator).operate(first, second);
    }

    private static void validSize(String[] values) {
        for (String value : values) {
            validNullAndEmpty(value);
        }
        if (isEven(values)) {
            throw new IllegalArgumentException(VALID_ARITHMETHIC_INPUT_SIZE);
        }
    }

    private static boolean isEven(String[] values) {
        return (values.length % 2) == 0;
    }

}

package step2;

import java.util.Objects;

public class Calculator {

    private final static String delimiter = " ";

    private Calculator() {}

    public static int calculate(String input) {
        validText(input);

        String[] values = splitTextByDelimiter(input, delimiter);

        Formula formula = Formula.builder()
                            .setFirst(new MyNumber(values[0]))
                            .setOperator(values[1])
                            .setSecond(new MyNumber(values[2]))
                            .build();

        return calculate(formula).getNumber();
    }

    public static MyNumber calculateMulti(String input) {
        String[] values = splitTextByDelimiter(input, delimiter);

        int cnt = values.length;

        MyNumber first = new MyNumber(values[0]);
        Formula formula = null;

        for(int i = 1 ; i < cnt ; i += 2) {
            formula = Formula.builder()
                        .setFirst(first)
                        .setOperator(values[i])
                        .setSecond(new MyNumber(values[i+1]))
                        .build();

            first = calculate(formula);
        }

        return first;
    }

    private static MyNumber calculate(Formula formula) {
        return Operator.of(formula.getOperator())
                            .apply(formula.getFirst(), formula.getSecond());
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

package step2;

public class Calculator {

    private final static String delimiter = " ";

    private Calculator() {
        throw new AssertionError(MyException.FAIL_TO_NEW_CLASS.getMessage());
    }

    public static int calculate(String input) {
        isValidText(input);

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

        return first.getNumber();
    }

    private static MyNumber calculate(Formula formula) {
        return Operator.of(formula.getOperator())
                            .apply(formula.getFirst(), formula.getSecond());
    }

    public static void isValidText(String text) {
        if(Common.textNullOrEmpty(text)) {
            throw new IllegalArgumentException(MyException.EMPTY_INPUT.getMessage());
        }
    }

    private static String[] splitTextByDelimiter(String text, String delimiter) {
        return text.split(delimiter);
    }
}

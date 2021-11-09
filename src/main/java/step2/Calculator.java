package step2;

public class Calculator {

    public static int calculate(String text) {
        final String[] values = validInputData(text);

        MyNumber first = new MyNumber(values[0]);
        for (int i = 1; i < values.length - 1; i += 2) {
            String operator = values[i];
            MyNumber second = new MyNumber(values[i + 1]);
            first = calculate(first, operator, second);
        }
        return first.getNumber();
    }

    private static String[] validInputData(String text) {
        Validation.validNullAndEmpty(text);
        final String[] values = text.split(" ");
        Validation.validSize(values);
        return values;
    }

    private static MyNumber calculate(MyNumber first, String operator, MyNumber second) {
        return Operator.of(operator).operate(first, second);
    }

}

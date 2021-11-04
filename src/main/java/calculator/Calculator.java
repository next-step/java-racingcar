package calculator;

public class Calculator {
    private static final String OPERATION_DELIMITER = " ";

    public static MyNumber calculate(String s) {
        String[] values = s.split(OPERATION_DELIMITER);
        MyNumber first = new MyNumber(values[0]);
        String operator = values[1];
        MyNumber second = new MyNumber(values[2]);

        return Operator.of(operator)
                .calculate(first, second);
    }
}

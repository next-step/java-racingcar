package calculator;

public class Calculator {
    private static final String SEPARATOR = " ";

    public static int calculate(String text) {
        InputCheckor.checkInput(text);
        String[] values = text.split(SEPARATOR);
        MyNumber result = new MyNumber(values[0]);
        MyNumber second;
        String symbol;
        for (int i = 1; i < values.length - 1; i = i + 2) {
            second = new MyNumber(values[i + 1]);
            symbol = values[i];
            result = calculate(result, symbol, second);
        }
        return result.getNumber();
    }

    private static MyNumber calculate(MyNumber first, String symbol, MyNumber second) {
        return Operator.of(symbol).calculate(first, second);
    }

}

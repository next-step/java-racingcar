package calculator;

import java.util.Objects;

public class Calculator {
    public static final String SEPARATOR = " ";
    public static final String PLUS_SYMBOL = "+";
    public static final String MINUS_SYMBOL = "-";
    public static final String MULTIPLE_SYMBOL = "*";
    public static final String DIVIDE_SYMBOL = "/";
    public static final int MINIMUM_TEXT_LENGTH = 5;

    public static int calculate(String text) {
        checkInput(text);
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

    private static void checkInput(String text) {
        if (Objects.isNull(text)) {
            throw new IllegalArgumentException("입력이 존재하지 않습니다.");
        }
        if (text.length() < MINIMUM_TEXT_LENGTH) {
            throw new IllegalArgumentException("잘못된 입력 입니다. (최소 하나의 연산 기호와 2개의 숫자 입력값 필요.)");
        }
    }

}

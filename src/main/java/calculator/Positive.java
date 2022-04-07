package calculator;

public class Positive {
    private final int number;
    static private final String NUMBER_REGEX_EXPRESSION = "^(?!-)[0-9]+";

    Positive(String value) {
        number = isValidNumber(value);
    }

    private int isValidNumber(String value) {
        if(isOnlyNumber(value)) {
            return Integer.parseInt(value);
        }
        throw new IllegalArgumentException("음수이거나 숫자가 아닌 값을 입력하여 예외가 발생합니다.");
    }

    private boolean isOnlyNumber(String value) {
        return value.matches(NUMBER_REGEX_EXPRESSION);
    }

    public int getNumber() {
        return number;
    }
}

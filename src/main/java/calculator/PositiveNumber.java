package calculator;

public class PositiveNumber {

    private static final String NOT_POSITIVE_MESSAGE = "음수는 불가합니다.";
    private final int number;

    public PositiveNumber(int number) {
        if(number < 0){
            throw new RuntimeException(NOT_POSITIVE_MESSAGE);
        }
        this.number = number;
    }

    public PositiveNumber(String text) {
        this(Integer.parseInt(text));
    }

    public int getValue() {
        return number;
    }
}

package calculator;

public class Number {
    private final static String NOT_NUMBER_REGEX = "//D+";
    private final int item;
    public Number(String input) {
        // 유효성 검증
        if (input == null || input.isEmpty() || input.matches(NOT_NUMBER_REGEX)) {
            throw new IllegalArgumentException();
        }
        this.item = Integer.parseInt(input);
    }
    public Number(int input) {
        this.item = input;
    }
    public Integer getItem() {
        return item;
    }
}

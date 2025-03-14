package step2;

public class PositiveNumber {
    private final int number;

    public PositiveNumber(String number) {
        try {
            int value = Integer.parseInt(number);
            if (value < 0) {
                throw new RuntimeException("음수는 입력할 수 없습니다. 입력값: " + value);
            }
            this.number = value;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값이 포함되어 있습니다. 입력값: " + number);
        }
    }

    public int getValue() {
        return number;
    }
}

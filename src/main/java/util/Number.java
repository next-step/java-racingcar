package util;

public class Number {
    private final int number;

    public Number(int number) {
        validatePositiveNumber(number);
        this.number = number;
    }

    private void validatePositiveNumber(int value) {
        if (value < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    public int getNumber() {
        return number;
    }

}

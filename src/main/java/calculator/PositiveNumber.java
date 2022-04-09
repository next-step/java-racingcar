package calculator;

public class PositiveNumber {
    private final int number;

    PositiveNumber(String value) {
        this(Integer.parseInt(value));
    }

    PositiveNumber(int number) {
        if(number < 0) {
            throw new RuntimeException("음수는 허용하지 않습니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

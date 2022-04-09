package calculator;

public class Positive {
    private int number;

    Positive(String value) {
        this(Integer.parseInt(value));
    }

    Positive(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 허용되지 않습니다.");
        }
        this.number = number;
    }
}

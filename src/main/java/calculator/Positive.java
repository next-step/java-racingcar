package calculator;

public class Positive {
    private final int number;

    public Positive(String value) {
        try {
            this.number = Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new RuntimeException("숫자로 변환할 수 없는 입력값입니다.");
        }
        if (this.number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    public int number() {
        return this.number;
    }
}

package calculator.vo;

public class PositiveNumber {
    public final int value;

    public PositiveNumber(int value) {
        if (value < 0) {
            throw new RuntimeException("계산기의 숫자는 양수여야 합니다.");
        }
        this.value = value;
    }
}

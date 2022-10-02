package racingcar;

public class PositiveNumber {
    private int number;

    public
    PositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Positive는 양수만 들어올 수 있습니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

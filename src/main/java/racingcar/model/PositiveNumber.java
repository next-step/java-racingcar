package racingcar.model;

public class PositiveNumber {
    private int number;

    public PositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 허용하지 않습니다.");
        }
        this.number = number;
    }

    public void add(PositiveNumber positiveNumber) {
        this.number = this.number + positiveNumber.number;
    }

    public Boolean isGreaterThanOrEqual(int number) {
        return this.number >= number;
    }

    public int getNumber() {
        return this.number;
    }
}

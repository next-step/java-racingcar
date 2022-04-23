package racingcar.model;

public class PositiveNumber {
    private int number;

    public PositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 허용하지 않습니다.");
        }
        this.number = number;
    }

    public void plus(PositiveNumber positiveNumber) {
        this.number = this.number + positiveNumber.number;
    }

    public void minus(PositiveNumber positiveNumber) {
        if (this.number - positiveNumber.number >= 0) {
            this.number = this.number - positiveNumber.number;
            return;
        }
        throw new RuntimeException("뺼셈의 결과로 음수를 허용하지 않습니다.");
    }

    public boolean isMaxNumber(int maxNumber) {
        return this.number == maxNumber;
    }

    public Boolean isGreaterThanOrEqual(int number) {
        return this.number >= number;
    }

    public Boolean isZero() {
        return this.number == 0;
    }

    public int maxNumber(int maxNumber) {
        if (this.number >= maxNumber) {
            return this.number;
        }
        return maxNumber;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositiveNumber that = (PositiveNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}

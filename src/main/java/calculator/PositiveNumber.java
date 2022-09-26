package calculator;

import utils.StringUtils;

public class PositiveNumber {
    private final int number;

    public PositiveNumber(String value) {
        if (!StringUtils.isPositiveNumeric(value)) {
            throw new IllegalArgumentException("숫자가 아닌 문자열은 들어올 수 없습니다.");
        }
        this.number = Integer.parseInt(value);
    }

    public PositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수 값이 들어올 수 없습니다.");
        }
        this.number = number;
    }

    public PositiveNumber plus(PositiveNumber number) {
        return new PositiveNumber(this.number + number.getNumber()); // immutable 객체를 위한 인스턴스화
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositiveNumber)) return false;

        PositiveNumber positiveNumber = (PositiveNumber) o;

        return number == positiveNumber.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}

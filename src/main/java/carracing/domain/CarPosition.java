package carracing.domain;

import java.util.Objects;

/**
 * 자동차 위치 클래스
 */
public class CarPosition {
    private static final int INITIATION_POSITION_NUMBER = 0;

    private final int number;

    CarPosition() {
        this.number = INITIATION_POSITION_NUMBER;
    }

    CarPosition(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (isNegativeNumber(number)) {
            throw new IllegalArgumentException(String.format("자동차 위치(%d)는 0 또는 양의 정수가 입력되어야합니다.", number));
        }
    }

    private boolean isNegativeNumber(int position) {
        return position < 0;
    }

    public boolean isSameWith(int number) {
        return this.number == number;
    }

    public CarPosition move() {
        return new CarPosition(this.number + 1);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

package domain;

import java.util.Objects;

public class CarPosition {
    private final int position;
    public CarPosition(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("현재 위치 값이 음수일 수는 없습니다.");
        }
    }
    public int getValue() {
        return position;
    }

    public CarPosition move() {
        return new CarPosition(position+1);
    }

    public boolean isBiggerThan(CarPosition maxPosition) {
        return position > maxPosition.getValue();
    }

    public boolean isEqualThan(CarPosition maxPosition) {
        return position == maxPosition.getValue();
    }

    @Override
    public boolean equals(Object ob) {
        if (this == ob) return true;
        if (ob == null || getClass() != ob.getClass()) return false;
        CarPosition that = (CarPosition) ob;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
package step2.racing_mvc.domain;

import java.util.Objects;

public class RacingCarPosition {
    private final int position;

    public RacingCarPosition(int position) {
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

    public RacingCarPosition move() {
        return new RacingCarPosition(position+1);
    }

    public boolean isBiggerThan(RacingCarPosition maxPosition) {
        return position > maxPosition.getValue();
    }

    public boolean isEqualThan(RacingCarPosition maxPosition) {
        return position == maxPosition.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarPosition that = (RacingCarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
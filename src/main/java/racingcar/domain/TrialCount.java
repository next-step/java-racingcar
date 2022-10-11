package racingcar.domain;

import java.util.Objects;

public class TrialCount {
    private static final int MIN_COUNT = 1;

    private int count;

    public TrialCount(int count) {
        validateNumberOverMinimum(count);
        this.count = count;
    }

    private void validateNumberOverMinimum(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상 입니다.");
        }
    }

    public boolean isRemain() {
        return count >= MIN_COUNT;
    }

    public void decrease() {
        count--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrialCount that = (TrialCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}

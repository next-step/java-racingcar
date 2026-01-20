package carracing.domain;

import java.util.Objects;

public class TryCount {
    private final int value;

    public TryCount(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 작을 수 없습니다.");
        }
    }

    public boolean countOver() {
        return value == 0;
    }

    public TryCount consume() {
        return new TryCount(value - 1);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        TryCount tryCount = (TryCount) object;
        return value == tryCount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}

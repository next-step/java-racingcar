package racinggame.domain;

import java.util.Objects;

class TryNo {
    private final int value;

    TryNo(String value) {
        this(Integer.parseInt(value));
    }

    TryNo(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("시도횟수는 음수 값을 허용하지 않습니다.");
        }
        this.value = value;
    }

    TryNo decrease() {
        return new TryNo(this.value - 1);
    }

    boolean isPositive() {
        return this.value > 0;
    }

    boolean isZeo() {
        return this.value == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryNo tryNo = (TryNo) o;
        return value == tryNo.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "TryNo{" +
                "value=" + value +
                '}';
    }
}

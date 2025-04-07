package domain;

import java.util.Objects;

public class TryNum {
    private int tryNum;

    public TryNum(int value) {
        valid(value);
        this.tryNum = value;
    }

    private static void valid(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }
    }

    public boolean isEnd() {
        return this.tryNum == 0;
    }

    public void minusOne() {
        this.tryNum--;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TryNum tryNum1 = (TryNum) o;
        return tryNum == tryNum1.tryNum;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tryNum);
    }
}

package racinggame.domain;

import java.util.Objects;

public class TryNo {
    private int tryNo;

    public TryNo(int tryNo) {
        if (tryNo < 1) {
            throw new IllegalArgumentException("시도 횟수는 1이상의 값이어야 합니다.");
        }
        this.tryNo = tryNo;
    }

    public void race() {
        tryNo--;
    }

    public boolean racing() {
        return tryNo > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryNo tryNo1 = (TryNo) o;
        return tryNo == tryNo1.tryNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryNo);
    }
}

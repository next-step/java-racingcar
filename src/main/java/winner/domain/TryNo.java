package winner.domain;

import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-01 12:45
 */
public class TryNo {

    private static final int DECREASE = 1;
    private static final int MINIMUM_TRY_NO = 0;

    private final int tryNo;

    public TryNo(int tryNo) {
        if (tryNo < MINIMUM_TRY_NO) {
            throw new IllegalArgumentException("0 이상의 숫자만 입력가능합니다.");
        }

        this.tryNo = tryNo;
    }

    public boolean isNotEnd() {
        return this.tryNo > 0;
    }

    public TryNo decrease() {
        return new TryNo(tryNo - DECREASE);
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

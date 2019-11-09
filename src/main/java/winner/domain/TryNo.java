package winner.domain;

import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-01 12:45
 */
public class TryNo {

    private int tryNo;

    public TryNo(int tryNo) {
        if (tryNo <= 0) {
            throw new IllegalArgumentException("0 이상의 숫자만 입력가능합니다.");
        }

        this.tryNo = tryNo;
    }

    public boolean isNotEnd() {
        return this.tryNo > 0;
    }

    public void decrease() {
        this.tryNo--;
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

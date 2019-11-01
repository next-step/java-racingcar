package winner.domain;

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

    public boolean isEnd() {
        return this.tryNo == 0;
    }

    public void race() {
        this.tryNo--;
    }
}

package racingcar.domain;

public class TryCount {
    public final int TRY_COUNT;

    public TryCount(int tryCount) throws Exception {
        TRY_COUNT = isValid(tryCount);
    }

    private int isValid(int tryCount) throws Exception {
        if(tryCount >= 0)   return tryCount;
        throw new Exception("시도 횟수는 0이상의 값이어야 합니다.");
    }

}

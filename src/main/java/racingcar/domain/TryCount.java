package racingcar.domain;

public class TryCount extends NumberValidation {
    public final int tryCount;

    public TryCount(int tryCount) {
        this.tryCount = isValid(tryCount);
    }

}

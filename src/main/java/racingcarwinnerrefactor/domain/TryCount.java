package racingcarwinnerrefactor.domain;

import racingcarwinnerrefactor.exception.NumberException;
import racingcarwinnerrefactor.view.InputView;

public class TryCount {

    private final int count;
    private static TryCount tryCount;

    public static TryCount tryCountFactory() {
        if(tryCount == null)    tryCount = new TryCount(InputView.inputTryCount());
        return tryCount;
    }

    public TryCount() {
        this(InputView.inputTryCount());
    }

    public TryCount(int tryCount) {
        assertPositive(tryCount);
        this.count = tryCount;
    }

    public void assertPositive(int tryCount) {
        if(tryCount < 0) throw new NumberException();
    }

    public final int getCount() {
        return count;
    }
}

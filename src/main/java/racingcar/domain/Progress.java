package racingcar.domain;

public class Progress {
    private static final int INIT_TRY_COUNT = 0;
    
    private final int limitTryCount;
    private final int currentTryCount;

    public Progress(int tryCount) {
        limitTryCount = tryCount;
        currentTryCount = INIT_TRY_COUNT;
    }

    public Progress(int limitTryCount, int currentTryCount) {
        this.limitTryCount = limitTryCount;
        this.currentTryCount = currentTryCount;
    }

    public Progress proceed() {
        return new Progress(limitTryCount, currentTryCount+1);
    }

    public boolean isFinish() {
        return currentTryCount >= limitTryCount;
    }
}

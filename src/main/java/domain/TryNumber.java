package domain;

public class TryNumber {
    private int totalTryNumber;
    private int curTryCount;

    public TryNumber(int totalTry) {
        this.totalTryNumber = totalTry;
        this.curTryCount = 0;
    }

    public boolean isEnd() {
        return totalTryNumber == curTryCount;
    }

    public void increase() {
        curTryCount++;
    }
}

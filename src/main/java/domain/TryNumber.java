package domain;

public class TryNumber {
    private int totalTryNumber;
    private int curTryCount;

    public TryNumber(int totalTry) {
        this.totalTryNumber = totalTry;
    }

    public boolean isEnd() {
        return totalTryNumber == curTryCount;
    }

    public void increase() {
        curTryCount++;
    }
}

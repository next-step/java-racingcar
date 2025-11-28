package model;

public class TryCount {
    private int totalTryCount;
    private int curTryCount;

    public TryCount(int totalTryCount) {
        this.totalTryCount = totalTryCount;
        this.curTryCount = 0;
    }

    public void increase() {
        this.curTryCount++;
    }

    public boolean isEnd() {
        return  curTryCount == totalTryCount;
    }
}

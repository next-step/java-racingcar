package racinggame.domain;

public class Laps {
    private final int count;
    private int tryCount;

    public Laps(int count) {
        this.count = count;
        this.tryCount = 0;
    }

    public boolean isGoal() {
        return tryCount > count;
    }

    public void passStartLine() {
        tryCount++;
    }
}

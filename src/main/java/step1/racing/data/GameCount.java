package step1.racing.data;

public class GameCount {
    private final int maxCount;

    private int currentCount;

    public GameCount(int maxCount) {
        this.maxCount = maxCount;
        this.currentCount = 0;
        validate();
    }

    public boolean isPlayable() {
        return this.maxCount > currentCount++;
    }

    private void validate() {
        if (maxCount < 1) {
            throw new IllegalArgumentException();
        }
    }
}

package race;

public class TrackCondition {
    private final int maxCarCount;
    private final int maxAttemptCount;

    public TrackCondition(int maxCarCount, int maxAttemptCount) {
        this.maxCarCount = maxCarCount;
        this.maxAttemptCount = maxAttemptCount;
    }

    public boolean validateCarCount(int num) {
        return num >= 1 && num <= this.maxCarCount;
    }

    public boolean validateAttemptCount(int num) {
        return num >= 1 && num <= this.maxAttemptCount;
    }
}

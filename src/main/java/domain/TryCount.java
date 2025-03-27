package domain;

public class TryCount {
    public static final int BOUND = 0;
    private final Integer numberOfTrial;

    public TryCount(Integer numberOfTrial) {
        if (numberOfTrial <= BOUND) {
            String message = String.format("시도 횟수는 %d보다 커야 합니다.", BOUND);
            throw new IllegalArgumentException(message);
        }
        this.numberOfTrial = numberOfTrial;
    }

    public Integer getTryCount() {
        return numberOfTrial;
    }
}

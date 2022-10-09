package racing.domain;

public class Attempts {
    private final int numberOfAttempts;

    public Attempts(int numberOfAttempts) {

        if (numberOfAttempts < 0) {
            throw new IllegalArgumentException("시도 횟수는 0 이상이어야 합니다");
        }

        this.numberOfAttempts = numberOfAttempts;
    }

    public Attempts run() {
        return new Attempts(numberOfAttempts - 1);
    }

    public boolean isRemain() {
        return numberOfAttempts > 0;
    }
}

package carracing.view;

public class RacingCondition {
    private int carCount;
    private int attemptCount;

    public RacingCondition(int carCount, int attemptCount) {
        if (carCount < 0) {
            throw new RuntimeException("자동차 대수는 0 또는 양수만 가능합니다. 입력값=" + carCount);
        }

        if (attemptCount < 0) {
            throw new RuntimeException("시도할 회수는 0 또는 양수만 가능합니다. 입력값={}" + attemptCount);
        }

        this.carCount = carCount;
        this.attemptCount = attemptCount;
    }

    public Integer carCount() {
        return carCount;
    }

    public Integer attemptCount() {
        return attemptCount;
    }
}
package car_racing;

public class RacingCondition {
    private Integer carCount;
    private Integer attemptCount;

    public RacingCondition(Integer carCount, Integer attemptCount) {
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
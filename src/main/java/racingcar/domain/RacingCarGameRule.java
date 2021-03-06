package racingcar.domain;

public class RacingCarGameRule {

    private final MovingStrategy movingStrategy;

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public RacingCarGameRule(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public RacingCarGameRule() {
        this.movingStrategy = new DecidingNumberBasedMovingStrategy();
    }

    public void validateWhetherCarNameLengthLimit(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름이 너무 깁니다.");
        }
    }

    public void validateWhetherCarNameLengthLimit(String[] carNameArray) {
        for (String carName : carNameArray) {
            validateWhetherCarNameLengthLimit(carName);
        }
    }

    public boolean isCarMovable() {
        return movingStrategy.isMovable();
    }


}

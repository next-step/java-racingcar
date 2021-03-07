package racingcar.domain;

import racingcar.utils.StringUtil;

public class RacingCarGameRule {

    private final MovingStrategy movingStrategy;

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public RacingCarGameRule(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public RacingCarGameRule() {
        this.movingStrategy = new DecidingNumberBasedMovingStrategy();
    }

    public void validateCarName(String carName) {
        validateWhetherCarNameIsBlack(carName);
        validateWhetherCarNameLengthLimit(carName);
    }

    private void validateWhetherCarNameIsBlack(String carName) {
        if (StringUtil.isBlank(carName)) {
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
    }

    private void validateWhetherCarNameLengthLimit(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름이 너무 깁니다.");
        }
    }

    public void validateCarName(String[] carNameArray) {
        for (String carName : carNameArray) {
            validateCarName(carName);
        }
    }

    public boolean isCarMovable() {
        return movingStrategy.isMovable();
    }


}

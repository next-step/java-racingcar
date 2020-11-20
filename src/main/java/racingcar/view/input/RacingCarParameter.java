package racingcar.view.input;

import racingcar.common.Constant;

public class RacingCarParameter {
    private final String carNames;
    private final int racingCount;

    public RacingCarParameter(String carNames, int racingCount) {
        validRacingCount(racingCount);
        validRacingCarNames(carNames);
        this.carNames = carNames;
        this.racingCount = racingCount;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getRacingCount() {
        return racingCount;
    }

    private void validRacingCount(int racingCount) {
        if (racingCount < 0) {
            throw new IllegalArgumentException("racing count is not available");
        }
    }

    private void validRacingCarNames(String racingCarNames) {
        if (racingCarNames.equals(Constant.BLANK) || racingCarNames.equals(Constant.BLANK_STRING) || racingCarNames.isEmpty()) {
            throw new IllegalArgumentException("racing car name is wrong");
        }
    }
}

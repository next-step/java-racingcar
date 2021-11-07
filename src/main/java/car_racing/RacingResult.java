package car_racing;

import java.util.Objects;

public class RacingResult {
    private final StringBuilder racingResult;

    /* test */
    public RacingResult(String racingResult) {
        this.racingResult = new StringBuilder(racingResult);
    }

    public RacingResult() {
        this.racingResult = new StringBuilder();
    }

    public void update(Cars cars) {
        if (Objects.isNull(cars)) {
            return;
        }
        racingResult.append(cars.getCarsCurrStatuses());
    }

    public String getResult() {
        return racingResult.toString();
    }
}

package racing.domain;

import common.Verify;
import org.apache.commons.lang3.StringUtils;

import static racing.domain.CarRacingMessage.*;

public class CarRacing {

    private final Cars cars;
    private final int tryCount;

    private int racingCount = 0;

    public CarRacing(String carNames, int tryCount) {
        Verify.checkArgument(tryCount > 0, TRY_COUNT_ERROR_MESSAGE);
        Verify.checkArgument(StringUtils.isNotBlank(carNames), INVALID_NAMES_ERROR_MESSAGE);

        this.tryCount = tryCount;
        cars = new Cars(carNames);
    }

    public void race() {
        race(null);
    }

    public void race(CarConsumer carConsumer) {
        Verify.checkState(!isComplete(), RACE_COMPLETED_MESSAGE);

        cars.moveCars(carConsumer);
        racingCount++;
    }

    public boolean isComplete() {
        return tryCount == racingCount;
    }

    public int getRacingCount() {
        return racingCount;
    }

    public String[] getWinners() {
        Verify.checkState(isComplete(), RACE_NOT_COMPLETED_MESSAGE);
        return cars.getMaxMovedCarNames();
    }

}

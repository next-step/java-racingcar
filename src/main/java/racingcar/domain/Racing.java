package racingcar.domain;

import racingcar.domain.exception.AlreadyRaceFinishedException;
import racingcar.view.GameOutputView;

public class Racing {
    private static final int MIN_CAR_COUNT = 1;
    private static final int MIN_TRY_COUNT = 1;
    
    private final Cars cars;
    private final int tryCount;
    private int currentTryCount;

    private Racing(Cars cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void race(GameOutputView gameOutputView) {
        if (isFinish()) {
            throw new AlreadyRaceFinishedException();
        }
        currentTryCount++;
        gameOutputView.notify(cars.move());
    }
    
    public boolean isFinish() {
        return currentTryCount >= tryCount;
    }
    
    public static Racing of(int carCount, int tryCount) {
        if (carCount < MIN_CAR_COUNT || tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("Number of cars is greater than 0 and trial count must be greater than or equal to 1.");
        }
        return new Racing(Cars.create(carCount), tryCount);
    }
}

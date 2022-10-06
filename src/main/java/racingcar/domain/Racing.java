package racingcar.domain;

import racingcar.domain.exception.InvalidCarCountException;

public class Racing {
    private static final int MIN_CAR_COUNT = 1;
    private static final int MIN_TRY_COUNT = 1;
    
    private Progress progress;
    private final Cars cars;

    private Racing(Progress progress, Cars cars) {
        this.progress = progress;
        this.cars = cars;
    }

    public static Racing of(CarNames names, int tryCount) {
        if (names.carCount() < MIN_CAR_COUNT || tryCount < MIN_TRY_COUNT) {
            throw new InvalidCarCountException();
        }
        return racing(names, tryCount);
    }
    
    public Cars race() {
        progress = progress.proceed();
        cars.move();
        return cars;
    }

    public boolean isFinish() {
        return progress.isFinish();
    }
    
    private static Racing racing(CarNames names, int tryCount) {
        return new Racing(new Progress(tryCount), Cars.from(names));
    }
}

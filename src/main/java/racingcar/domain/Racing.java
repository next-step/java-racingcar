package racingcar.domain;

import racingcar.domain.exception.InvalidCarCountException;
import racingcar.domain.moving.MovingStrategy;

public class Racing {
    private static final int MIN_CAR_COUNT = 1;
    private static final int MIN_TRY_COUNT = 1;
    
    private Progress progress;
    private final Cars cars;

    public Racing(Progress progress, Cars cars) {
        this.progress = progress;
        this.cars = cars;
    }

    public static Racing of(CarNames names, int tryCount) {
        if (names.carCount() < MIN_CAR_COUNT || tryCount < MIN_TRY_COUNT) {
            throw new InvalidCarCountException();
        }
        return racing(names, tryCount);
    }
    
    public Cars race(MovingStrategy movingStrategy) {
        progress = progress.proceed();
        cars.move(movingStrategy);
        return cars;
    }

    public boolean isFinish() {
        return progress.isFinish();
    }
    
    private static Racing racing(CarNames names, int tryCount) {
        return new Racing(new Progress(tryCount), Cars.from(names));
    }
}

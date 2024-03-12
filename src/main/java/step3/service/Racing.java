package step3.service;

import step3.view.RacingOutputView;

public class Racing {
    private final Moving movingStrategy;
    private final CarsDto cars;
    private final int tryCount;

    public static Racing randomMoving(CarsDto cars, int tryCount) {
        return new Racing(cars, tryCount, new RandomMoving());
    }

    private Racing(CarsDto cars, int tryCount, Moving movingStrategy) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.movingStrategy = movingStrategy;
    }

    public void play() {
        if (isUnPlayable()) {
            return;
        }

        RacingOutputView.printResultTitle();
        for (int count = 0; count < tryCount; count++) {
            cars.moveAll(movingStrategy);
            RacingOutputView.printRacingResult(cars.movementResults());
        }
    }

    private boolean isUnPlayable() {
        return cars.isEmpty() || tryCount <= 0;
    }
}

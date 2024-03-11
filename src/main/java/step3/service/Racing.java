package step3.service;

import step3.view.RacingOutputView;

public class Racing {
    private final CarsDto cars;
    private final int tryCount;

    public static Racing of(CarsDto cars, int tryCount) {
        return new Racing(cars, tryCount);
    }

    private Racing(CarsDto cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void play() {
        if (isUnPlayable()) {
            return;
        }

        RacingOutputView.printResultTitle();
        for (int count = 0; count < tryCount; count++) {
            cars.moveAll();
            RacingOutputView.printRacingResult(cars.movementResults());
        }
    }

    private boolean isUnPlayable() {
        return cars.isEmpty() || tryCount <= 0;
    }
}

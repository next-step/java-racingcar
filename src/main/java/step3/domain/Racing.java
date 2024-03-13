package step3.domain;

import step3.view.result.CarMovementRoundResults;

public class Racing {
    private final Cars cars;
    private final int tryCount;
    private final Moving movingStrategy;
    private final CarMovementRoundResults results = new CarMovementRoundResults();

    public static Racing randomMoving(Cars cars, int tryCount) {
        return new Racing(cars, tryCount, new RandomMoving());
    }

    private Racing(Cars cars, int tryCount, Moving movingStrategy) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.movingStrategy = movingStrategy;
    }

    public CarMovementRoundResults playAndGenerateResults() {
        if (isUnPlayable()) {
            return results;
        }

        for (int count = 0; count < tryCount; count++) {
            cars.moveAll(movingStrategy);
            results.add(cars.roundResult());
        }

        return results;
    }

    private boolean isUnPlayable() {
        return cars.isEmpty() || tryCount <= 0;
    }
}

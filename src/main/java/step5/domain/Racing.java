package step5.domain;

import step5.domain.result.CarMovementRoundResults;

public class Racing {
    private final Cars cars;
    private final int tryCount;
    private final Moving movingStrategy;

    public static Racing randomMoving(Cars cars, int tryCount) {
        return new Racing(cars, tryCount, new RandomMoving());
    }

    private Racing(Cars cars, int tryCount, Moving movingStrategy) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.movingStrategy = movingStrategy;
    }

    public CarMovementRoundResults playAndGenerateResults() {
        final CarMovementRoundResults roundResults = new CarMovementRoundResults();
        if (isUnPlayable()) {
            return roundResults;
        }

        for (int count = 0; count < tryCount; count++) {
            cars.moveAll(movingStrategy);
            roundResults.add(cars.roundResult());
        }

        return roundResults;
    }

    private boolean isUnPlayable() {
        return cars.isEmpty() || tryCount <= 0;
    }
}

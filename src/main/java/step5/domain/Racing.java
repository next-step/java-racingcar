package step5.domain;

import step5.domain.result.CarMovementRoundResults;

public class Racing {
    private final Cars cars;
    private final TryCount tryCount;
    private final Moving movingStrategy;

    public static Racing randomMoving(Cars cars, int tryCount) {
        return new Racing(cars, tryCount, new RandomMoving());
    }

    private Racing(Cars cars, int tryCount, Moving movingStrategy) {
        this.cars = cars;
        this.tryCount = new TryCount(tryCount);
        this.movingStrategy = movingStrategy;
    }

    public CarMovementRoundResults playAndGenerateResults() {
        final CarMovementRoundResults roundResults = new CarMovementRoundResults();
        if (isUnPlayable()) {
            return roundResults;
        }

        tryCount.forEach(count -> roundResults.add(cars.moveAll(movingStrategy)));

        return roundResults;
    }

    private boolean isUnPlayable() {
        return cars.isEmpty() || tryCount.zeroOrLessThanZero();
    }
}

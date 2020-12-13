package racing.domain;

import java.util.function.IntConsumer;

import static racing.common.Verify.checkArgument;
import static racing.domain.CarRacingProperty.MAX_RANDOM_NUMBER;
import static racing.domain.CarRacingProperty.MIN_RANDOM_NUMBER;

public class CarRacing {

    private static final String RACE_COUNT_ERROR_MESSAGE = "The races must be at least 1";

    private final Cars cars;
    private final MoveStrategy moveStrategy;
    private final int raceCount;

    public CarRacing(Cars cars, int raceCount) {
        this(cars, new RandomMoveStrategy(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER), raceCount);
    }

    public CarRacing(Cars cars, MoveStrategy moveStrategy, int raceCount) {
        checkArgument(raceCount > 0, RACE_COUNT_ERROR_MESSAGE);
        this.cars = cars;
        this.moveStrategy = moveStrategy;
        this.raceCount = raceCount;
    }

    public void race(IntConsumer carConsumer, Runnable roundEnded) {
        for (int i = 0; i < raceCount; i++) {
            cars.moveAll(moveStrategy);
            cars.iterateCar(carConsumer);
            roundEnded.run();
        }
    }
}

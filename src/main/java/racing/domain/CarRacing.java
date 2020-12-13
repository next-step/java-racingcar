package racing.domain;

import java.util.function.IntConsumer;

import static racing.domain.CarRacingProperty.MAX_RANDOM_NUMBER;
import static racing.domain.CarRacingProperty.MIN_RANDOM_NUMBER;

public class CarRacing {

    private final Cars cars;
    private final MoveStrategy moveStrategy;
    private int raceCount;

    public CarRacing(Cars cars, int raceCount) {
        this(cars, new RandomMoveStrategy(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER), raceCount);
    }

    public CarRacing(Cars cars, MoveStrategy moveStrategy, int raceCount) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
        this.raceCount = raceCount;
    }

    public void race(IntConsumer consumer) {
        cars.moveAll(moveStrategy);
        cars.iterateCar(consumer);
        raceCount--;
    }

    public boolean isComplete() {
        return raceCount == 0;
    }
}

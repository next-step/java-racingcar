package racing.domain;

import racing.domain.strategies.CarMoveStrategy;
import racing.utils.Counter;

public class Car {
    public static final int RUN_STEP = 1;
    public static final int INIT_VALUE = 0;
    private final Counter counter = new Counter(INIT_VALUE);

    public Counter run(CarMoveStrategy carMoveStrategy) {
        if (carMoveStrategy.isMovable()) {
            counter.add(RUN_STEP);
        }
        return counter;
    }
}

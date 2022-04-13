package racing.domain;

import racing.domain.strategies.CarMoveStrategy;
import racing.utils.Counter;

public class Car {
    private static final int RUN_STEP = 1;
    private static final int INIT_VALUE = 0;
    private static final String NAME_EXCEPTION_MESSAGE = "자동차 이름은 5글자를 초과하지 않아야합니다.";
    private final Counter counter = new Counter(INIT_VALUE);
    private final String name;

    public Car(String nameOfCar) {
        if (nameOfCar == null || nameOfCar.isBlank() || nameOfCar.length() > 5) {
            throw new IllegalArgumentException(NAME_EXCEPTION_MESSAGE);
        }
        name = nameOfCar;
    }

    public void run(CarMoveStrategy carMoveStrategy) {
        if (carMoveStrategy.isMovable()) {
            counter.add(RUN_STEP);
        }
    }

    public String getName() {
        return name;
    }

    public Counter getCounter() {
        return new Counter(this.counter);
    }
}

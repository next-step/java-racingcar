package racing.domain;

import racing.domain.strategies.CarMoveStrategy;
import racing.utils.Counter;

public class Car {
    public static final int RUN_STEP = 1;
    public static final int INIT_VALUE = 0;
    private final Counter counter = new Counter(INIT_VALUE);
    private final String name;

    public Car(String nameOfCar) {
        if (nameOfCar == null || nameOfCar.isBlank() || nameOfCar.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과하지 않아야합니다.");
        }
        name = nameOfCar;
    }

    public Counter run(CarMoveStrategy carMoveStrategy) {
        if (carMoveStrategy.isMovable()) {
            counter.add(RUN_STEP);
        }
        return new Counter(this.counter);
    }

    public String getName() {
        return name;
    }
}

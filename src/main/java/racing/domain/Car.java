package racing.domain;

import racing.domain.strategies.CarMoveStrategy;

public class Car {
    private static final int RUN_STEP = 1;
    private static final String NAME_EXCEPTION_MESSAGE = "자동차 이름은 5글자를 초과하지 않아야합니다.";
    private final Position position;
    private final String name;

    public Car(String nameOfCar) {
        if (nameOfCar == null || nameOfCar.isBlank() || nameOfCar.length() > 5) {
            throw new IllegalArgumentException(NAME_EXCEPTION_MESSAGE);
        }
        name = nameOfCar;
        position = new Position();
    }

    public void run(CarMoveStrategy carMoveStrategy) {
        if (carMoveStrategy.isMovable()) {
            position.add(RUN_STEP);
        }
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return new Position(this.position);
    }
}

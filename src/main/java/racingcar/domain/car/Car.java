package racingcar.domain.car;

import racingcar.domain.car.strategy.CarActionStrategy;

public class Car {
    private static final int MOVABLE_DISTANCE = 1;

    private int position = 0;
    private final CarActionStrategy carActionStrategy;

    public Car(int position, CarActionStrategy carActionStrategy) {
        validateStrategy(carActionStrategy);
        this.position = position;
        this.carActionStrategy = carActionStrategy;
    }

    public Car(CarActionStrategy carActionStrategy) {
        validateStrategy(carActionStrategy);
        this.carActionStrategy = carActionStrategy;
    }

    private void validateStrategy(CarActionStrategy carActionStrategy) {
        if (carActionStrategy == null) {
            throw new IllegalArgumentException("CarActionStrategy없이 Car는 생성될 수 없습니다.");
        }
    }

    public int getPosition() {
        return this.position;
    }

    private Car goForward() {
        return new Car(position + MOVABLE_DISTANCE, carActionStrategy);
    }

    public Car act() {
        if (carActionStrategy.isMovable()) {
            return goForward();
        }
        return this;
    }
}

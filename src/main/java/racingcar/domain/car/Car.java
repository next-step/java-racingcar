package racingcar.domain.car;

import racingcar.domain.car.strategy.CarActionStrategy;

public class Car {
    private final CarPosition position;
    private final CarName name;
    private final CarActionStrategy carActionStrategy;

    public Car(CarName name, CarActionStrategy carActionStrategy) {
        this(name, CarPosition.createDefault(), carActionStrategy);
    }

    public Car(CarName name, CarPosition position, CarActionStrategy carActionStrategy) {
        validateCarAction(carActionStrategy);
        this.name = name;
        this.position = position;
        this.carActionStrategy = carActionStrategy;
    }

    private void validateCarAction(CarActionStrategy carActionStrategy) {
        if (carActionStrategy == null) {
            throw new IllegalArgumentException("CarActionStrategy없이 Car는 생성될 수 없습니다.");
        }
    }

    public CarPosition getPosition() {
        return this.position;
    }

    public CarName getName() {
        return name;
    }

    private Car goForward() {
        return new Car(this.name, position.increase(), carActionStrategy);
    }

    public Car act() {
        if (carActionStrategy.isMovable()) {
            return goForward();
        }
        return this;
    }
}

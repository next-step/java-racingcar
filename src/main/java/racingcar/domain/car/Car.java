package racingcar.domain.car;

import racingcar.domain.strategy.MovableStrategy;
import racingcar.domain.strategy.RandomMovableStrategy;

import java.util.Objects;

public class Car {
    private int position;
    private String name;
    private final MovableStrategy movableStrategy;

    private Car(CarPosition position, CarName carName, MovableStrategy movableStrategy) {
        if(Objects.isNull(movableStrategy)){
            throw new NullPointerException();
        }
        this.position = position.getPosition();
        this.name = carName.getName();
        this.movableStrategy = movableStrategy;
    }

    public static Car newInstance(CarName carName) {
        return newInstance(carName, new RandomMovableStrategy());
    }

    public static Car newInstance(CarName carName, MovableStrategy movableStrategy) {
        return newInstance(CarPosition.of(CarPosition.DEFAULT_POSITION), carName, movableStrategy);
    }

    public static Car newInstance(CarPosition carPosition, CarName carName, MovableStrategy movableStrategy) {
        return new Car(carPosition, carName, movableStrategy);
    }

    public int getPosition() {
        return position;
    }

    public void clearPosition() {
        this.position = CarPosition.DEFAULT_POSITION;
    }

    public String getName() {
        return name;
    }

    public int move() {
        this.position += movableStrategy.move();
        return position;
    }
}

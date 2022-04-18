package racingCar.domain;

import racingCar.MovableStrategy;

public class Car {

    private final MovableStrategy movableStrategy;

    private CarName name;
    private Position position;

    public Car(String name, MovableStrategy movableStrategy) {
        this.position = new Position();
        this.name = new CarName(name);
        this.movableStrategy = movableStrategy;
    }

    public int move(int value) {
        if (movableStrategy.canMove(value)) {
            return this.position.forward();
        }

        return 0;
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public String getName() {
        return name.getName();
    }
}

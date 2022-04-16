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

    public String move(int value) {
        if (movableStrategy.canMove(value)) {
            return this.position.forward();
        }

        return "";
    }

    public String getPosition() {
        return this.position.getPosition();
    }

    public String getName() {
        return name.getName();
    }
}

package step5.domain;

import step5.domain.stretagy.MovingStrategy;

public class Car {

    private final Name name;
    private final MovingStrategy movingStrategy;
    private final Position position = new Position();

    public Car(String name, MovingStrategy movingStrategy) {
        this.name = new Name(name);
        this.movingStrategy = movingStrategy;
    }

    public void race() {
        if (movingStrategy.isMoved()) {
            position.plusPosition();
        }
    }

    public int getNowPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

}

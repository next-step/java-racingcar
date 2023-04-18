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

    public String race() {
        if (movingStrategy.goOrStop()) {
            position.plusPosition();
        }
        return name + " : " + position;
    }

    public String getNowPosition() {
        return position.toString();
    }

    public String getName() {
        return name.getName();
    }

}

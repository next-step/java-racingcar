package racinggame.domain;

import racinggame.domain.rule.MoveStrategy;

public class Car {

    private final int MIN_MOVEMENT_VALUE = 4;
    private final int NON_NEGATIVE_CHECK = 0;
    private CarName carName;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.carName = new CarName(name);
        this.position = new Position(position);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.moveRule()) {
            position = position.move();
        }
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}

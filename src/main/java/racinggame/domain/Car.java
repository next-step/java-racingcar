package racinggame.domain;

import racinggame.domain.rule.MoveStrategy;
import racinggame.domain.rule.RandomMoveStrategy;

public class Car {

    private CarName carName;
    private Position position;
    private MoveStrategy moveStrategy;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.carName = new CarName(name);
        this.position = new Position(position);
        this.moveStrategy = new RandomMoveStrategy();
    }

    public Car(String name, int position, MoveStrategy moveStrategy) {
        this.carName = new CarName(name);
        this.position = new Position(position);
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.move()) {
            position = position.add();
        }
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}

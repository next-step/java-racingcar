package new_racingcar.domain;

import new_racingcar.strategy.MoveStrategy;
import new_racingcar.constant.MsgConstants;

public class Car {
    private Name name;
    private MoveStrategy moveStrategy;
    private Distance distance;

    public Car(String name, MoveStrategy moveStrategy) {
        this(new Name(name), moveStrategy, new Distance());
    }

    public Car(Name name, MoveStrategy moveStrategy, Distance distance) {
        this.name = name;
        this.distance = distance;
        this.moveStrategy = moveStrategy;
    }

    public Car move() {
        if (moveStrategy.isMoveable()) {
            distance = distance.addDistance();
        }

        return new Car(name, moveStrategy, distance);
    }

    public Car move(MoveStrategy strategy) {
        setMoveStrategy(strategy);

        if (moveStrategy.isMoveable()) {
            distance = distance.addDistance();
        }

        return new Car(name, moveStrategy, distance);
    }

    private void setMoveStrategy(MoveStrategy strategy) {
        this.moveStrategy = strategy;
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }
}

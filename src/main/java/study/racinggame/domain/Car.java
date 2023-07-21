package study.racinggame.domain;

import study.racinggame.domain.strategy.MoveStrategy;

public class Car {
    private final Position position;
    private final Name name;

    public Car(Position position, Name name) {
        this.position = position;
        this.name = name;
    }

    public Car(String name) {
        this(new Position(), new Name(name));
    }

    public int getPosition() {
        return position.getPosition();
    }

    public boolean isHigherPosition(int another) {
        return position.isHigherPosition(another);
    }

    public boolean isMaxPosition(int maxPosition) {
        return position.isMaxPosition(maxPosition);
    }

    public String getName() {
        return name.getName();
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            position.increase();
        }
    }
}

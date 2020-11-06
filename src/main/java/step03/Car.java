package step03;

import step03.strategy.MoveStrategy;

public class Car {
    private int position;
    private final MoveStrategy moveStrategy;

    private Car(int position, MoveStrategy moveStrategy) {
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    public static Car of(int position, MoveStrategy moveStrategy) {
        return new Car(position, moveStrategy);
    }

    public void move () {
        if (moveStrategy.isGoing()) {
            position += 1;
        }
    }

    public int position() {
        return this.position;
    }

}

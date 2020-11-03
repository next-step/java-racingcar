package step03;

import step03.strategy.MoveStrategy;

public class Car {
    private int position;

    private Car(int position) {
        this.position = position;
    }

    public static Car of(int position) {
        return new Car(position);
    }

    public static Car of() {
        final int defaultPosition = 1;
        return new Car(defaultPosition);
    }

    public void move (MoveStrategy moveStrategy) {
        if (moveStrategy.isGoing()) {
            position += 1;
        }
    }

    public int position() {
        return this.position;
    }

}

package racewinner;

import racewinner.strategy.MoveStrategy;

public class Car {
    private final String name;
    private final MoveStrategy moveStrategy;
    private int position = 0;

    public Car(final String name, final MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.isMoved()) {
            position++;
        }
    }

    public String name() {
        return name;
    }
    public int currentStep() {
        return position;
    }
}

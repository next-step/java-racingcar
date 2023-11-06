package racewinner;

import racewinner.strategy.MoveStrategy;

public class Car {
    private final String name;
    private final MoveStrategy moveStrategy;
    private int position = 0;
    private final static String STEP_STRING = "-";


    public Car(final String name, final MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.isMoved()) {
            position++;
        }
    }

    public int currentStep() {
        return position;
    }


    @Override
    public String toString() {
        return String.format("%s : %s", name, STEP_STRING.repeat(position));
    }
}

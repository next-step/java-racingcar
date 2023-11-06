package racewinner;

import racewinner.strategy.MoveStrategy;

import java.util.Random;

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
        final int number = moveStrategy.getNumber();
        if (number >= 4) {
            position++;
        }
    }

    public int currentStep() {
        return position;
    }

    public String name() { return name; }

    @Override
    public String toString() {
        return String.format("%s : %s", name, STEP_STRING.repeat(position));
    }

}

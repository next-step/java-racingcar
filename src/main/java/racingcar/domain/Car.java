package racingcar.domain;

import racingcar.domain.movable.MovableStrategy;

public class Car {

    private final String name;
    private final MovableStrategy strategy;
    private int step;

    private Car(final String name, final MovableStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
        this.step = 0;
    }

    public Car(final String name, final MovableStrategy strategy, final int step) {
        this.name = name;
        this.strategy = strategy;
        this.step = step;
    }

    public static Car of(final String name, final MovableStrategy strategy) {
        return new Car(name, strategy);
    }

    public void moveForward() {
        if (strategy.move()) {
            this.step++;
        }
    }

    public int getStep() {
        return step;
    }

    public String getName() {
        return name;
    }

}

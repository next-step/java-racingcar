package racingcar.domain;

import racingcar.strategy.NumberGenerateStrategy;

public class Car {

    private static final int AVAILABLE_MOVE_BOUND = 4;

    private String name;
    private int position;

    private Car() {}

    public Car(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(final NumberGenerateStrategy strategy) {
        if (strategy.generate() >= AVAILABLE_MOVE_BOUND) {
            this.position += 1;
        }
    }
}

package racingcar;

import racingcar.strategy.NumberGenerateStrategy;
import racingcar.strategy.RandomNumberGenerateStrategy;

public class Car {

    private static final int AVAILABLE_MOVE_BOUND = 4;

    private String name;
    private int position;
    private NumberGenerateStrategy strategy;

    private Car() {}

    public Car(final String name) {
        this.name = name;
        this.strategy = new RandomNumberGenerateStrategy();
    }

    public Car(final String name, final NumberGenerateStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        if (strategy.generate() >= AVAILABLE_MOVE_BOUND) {
            this.position += 1;
        }
    }
}

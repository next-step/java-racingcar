package racingcar.model;

import racingcar.generator.NumberGenerator;
import racingcar.generator.RandomNumberGenerator;

public class Car {
    protected static final int MOVABLE_NUMBER = 4;
    private static final int DEFAULT_POSITION = 0;
    private static final RandomNumberGenerator DEFAULT_NUMBER_GENERATOR = new RandomNumberGenerator();

    private int position;

    public Car() {
        this(DEFAULT_POSITION);
    }

    protected Car(int position) {
        this.position = position;
    }

    public void move() {
        move(DEFAULT_NUMBER_GENERATOR);
    }

    public int getPosition() {
        return this.position;
    }

    protected boolean move(NumberGenerator numberGenerator) {
        if (numberGenerator.generate() >= MOVABLE_NUMBER) {
            this.position++;
            return true;
        }

        return false;
    }
}

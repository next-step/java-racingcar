package racingcar.model;

import racingcar.generator.NumberGenerator;

public class Car {
    public static final int MOVABLE_NUMBER = 4;
    private static final int DEFAULT_POSITION = 1;

    private int position;

    public Car() {
        this(DEFAULT_POSITION);
    }

    public Car(int position) {
        this.position = position;
    }

    public boolean move(NumberGenerator numberGenerator) {
        if (numberGenerator.generate() >= MOVABLE_NUMBER) {
            this.position++;
            return true;
        }

        return false;
    }

    public int getPosition() {
        return this.position;
    }

}

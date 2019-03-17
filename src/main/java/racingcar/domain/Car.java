package racingcar.domain;

import racingcar.utils.NumberGenerator;

public class Car {
    private static final int LOWER_LIMIT_OF_MOVE = 4;
    private final String name;
    private int position = 0;

    public Car(final String name) {
        this.name = name;
    }

    public void move(NumberGenerator numberGenerator) {
        if (numberGenerator.generateNumber() >= LOWER_LIMIT_OF_MOVE) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
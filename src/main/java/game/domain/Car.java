package game.domain;

import game.util.NumberGenerator;

public class Car {
    private static final int MOVE_CRITERIA = 4;

    private final NumberGenerator numberGenerator;

    private int position = 0;

    public Car(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void drive() {
        if (isMove(numberGenerator.generate())) {
            position++;
        }
    }

    private boolean isMove(int number) {
        return number >= MOVE_CRITERIA;
    }

    public int position() {
        return position;
    }
}
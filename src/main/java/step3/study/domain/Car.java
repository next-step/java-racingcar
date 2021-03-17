package step3.study.domain;

import step3.study.util.NumberGenerator;

public class Car {
    private Position position;
    private static final int MOVE_CONDITION = 4;

    public Car() {
    }

    public Car(Position position) {
        this.position = position;
    }

    public void move(NumberGenerator numberGenerator) {
        if (MOVE_CONDITION <= numberGenerator.createNumber()) {
            position.increase();
        }
    }

    public int position() {
        return position.getPosition();
    }
}

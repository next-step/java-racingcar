package step3.domain;

import step3.domain.history.CarHistory;
import step3.service.IntNumberGenerator;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private int position;

    private Car() {
        this.position = 0;
    }

    public static Car create() {
        return new Car();
    }

    public CarHistory move(IntNumberGenerator generator) {
        if (isMove(generator)) {
            position++;
        }
        return new CarHistory(this);
    }

    public int getPosition() {
        return this.position;
    }

    private boolean isMove(IntNumberGenerator generator) {
        return generator.generate() >= MOVE_CONDITION;
    }
}

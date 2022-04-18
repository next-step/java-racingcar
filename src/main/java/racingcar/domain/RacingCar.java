package racingcar.domain;

import java.util.Random;

public class RacingCar {
    private static final int MOVE_UNIT = 1;
    private int position;
    private Condition condition;

    public RacingCar(Condition condition) {
        this.position = 0;
        this.condition = condition;
    }

    public int moveOrStop() {
        if (condition.getCondition()) {
            position += MOVE_UNIT;
        }

        return position;
    }
}

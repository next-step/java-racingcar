package study.step5;

import study.step5.domain.CarMoveCondition;

public class MockRandomCarMoveCondition implements CarMoveCondition {
    private final static int MOVE_CONDITION_NUMBER = 4;

    private int randomInt;

    public MockRandomCarMoveCondition(int randomInt) {
        this.randomInt = randomInt;
    }

    @Override
    public boolean isCarMoveCondition() {
        return randomInt >= MOVE_CONDITION_NUMBER;
    }
}

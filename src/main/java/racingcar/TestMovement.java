package racingcar;

public class TestMovement implements Movement {
    private static final int MOVE_CONDITION = 4;
    private final int fixedValue;

    public TestMovement(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    public boolean isMove() {
        return fixedValue >= MOVE_CONDITION;
    }
}

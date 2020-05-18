package study.step3;

public class MockRandomGenerator implements CarMoveCondition{
    private final static int MOVE_CONDITION_NUMBER = 4;

    private int randomInt;

    public MockRandomGenerator(int randomInt) {
        this.randomInt = randomInt;
    }

    @Override
    public boolean isCarMoveCondition() {
        return randomInt >= MOVE_CONDITION_NUMBER;
    }
}

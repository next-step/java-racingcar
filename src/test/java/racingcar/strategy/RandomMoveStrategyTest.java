package racingcar.strategy;

public class RandomMoveStrategyTest implements MoveStrategy{
    private final int testNumber;
    private static final int CONDITION_NUMBER = 4;
    public RandomMoveStrategyTest(int testNumber) {
        this.testNumber = testNumber;
    }

    @Override
    public int randomNumber() {
        return this.testNumber;
    }

    @Override
    public boolean ableMove() {
        return randomNumber() >= CONDITION_NUMBER;
    }
}

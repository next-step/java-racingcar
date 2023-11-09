package racingcar.strategy;

public class RandomMoveStrategyTest implements MoveStrategy{
    private final int testNumber;
    public RandomMoveStrategyTest(int testNumber) {
        this.testNumber = testNumber;
    }

    @Override
    public int randomNumber() {
        return this.testNumber;
    }
}

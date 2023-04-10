package racingcar.strategy;

public class TestAlwaysMoveStrategy implements MoveStrategy {
    private int position;

    public TestAlwaysMoveStrategy() {
        position = 0;
    }

    @Override
    public boolean shouldMove() {
        position++;
        return true;
    }

    public int getPosition() {
        return position;
    }
}

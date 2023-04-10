package racingcar.strategy;

public class TestAlwaysStopStrategy implements MoveStrategy {
    private int position;

    public TestAlwaysStopStrategy() {
        position = 0;
    }

    @Override
    public boolean shouldMove() {
        return false;
    }

    public int getPosition() {
        return position;
    }
}

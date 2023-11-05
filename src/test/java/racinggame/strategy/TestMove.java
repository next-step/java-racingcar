package racinggame.strategy;

public class TestMove implements MoveStrategy {

    private final int number;

    public TestMove(int number) {
        this.number = number;
    }

    @Override
    public int number() {
        return this.number;
    }

}

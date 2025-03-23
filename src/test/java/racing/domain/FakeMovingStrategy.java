package racing.domain;

public class FakeMovingStrategy implements MovingStrategy {
    public static final int MOVE_CONDITION = 4;
    private final int num;

    public FakeMovingStrategy(int num) {
        this.num = num;
    }

    @Override
    public boolean movable() {
        return num >= MOVE_CONDITION;
    }
}

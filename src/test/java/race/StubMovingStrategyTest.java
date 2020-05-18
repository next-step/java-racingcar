package race;

public class StubMovingStrategyTest implements MovingStrategy {

    private boolean isMovable;
    public StubMovingStrategyTest(boolean isMovable) {
        this.isMovable = isMovable;
    }

    @Override
    public boolean isMovable() {
        return isMovable;
    }
}

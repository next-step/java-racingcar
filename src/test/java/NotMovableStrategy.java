import strategy.MovingStrategy;

public class NotMovableStrategy implements MovingStrategy {
    @Override
    public boolean movable() {
        return false;
    }
}

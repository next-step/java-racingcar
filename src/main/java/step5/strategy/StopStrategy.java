package step5.strategy;

public class StopStrategy implements MovableStrategy {

    @Override
    public boolean isMovable() {
        return false;
    }
}

package racingcar.strategy;

public class AlwaysMovableStrategy implements MovableStrategy {
    @Override
    public boolean isMovable() {
        return true;
    }
}

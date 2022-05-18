package racingcar.domain;

public class TrueMovableStrategy implements MovableStrategy {
    @Override
    public boolean isMovable() {
        return true;
    }
}

package racingcar.strategy;

public class TrueMovableStrategy implements MovableStrategy{
    @Override
    public boolean canMove() {
        return true;
    }
}

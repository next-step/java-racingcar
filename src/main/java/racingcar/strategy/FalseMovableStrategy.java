package racingcar.strategy;

public class FalseMovableStrategy implements MovableStrategy{
    @Override
    public boolean canMove() {
        return false;
    }
}

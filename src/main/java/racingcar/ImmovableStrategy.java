package racingcar;

public class ImmovableStrategy implements MoveStrategy {
    @Override
    public boolean isMove() {
        return false;
    }
}
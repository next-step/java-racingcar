package racingcar;

public class AlwaysMoveStrategy implements MoveStrategy {

    @Override
    public boolean isMovable() {
        return true;
    }
}

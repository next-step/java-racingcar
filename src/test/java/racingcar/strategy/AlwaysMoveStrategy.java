package racingcar.strategy;

public class AlwaysMoveStrategy implements MoveStrategy {

    @Override
    public boolean shouldMove() {
        return true;
    }
}

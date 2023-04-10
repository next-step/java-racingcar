package racingcar.strategy;

public class AlwaysStopStrategy implements MoveStrategy {

    @Override
    public boolean shouldMove() {
        return false;
    }
}

package racingcar.strategy;

public class AlwaysMoveStrategy implements IMoveStrategy {

    @Override
    public boolean canMove() {
        return true;
    }
}
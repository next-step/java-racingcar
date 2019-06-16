package camp.nextstep.edu.racingcar.domain;

public class MoveOnlyStrategy implements MovingStrategy {
    @Override
    public Integer getDistanceToMove() {
        return 1;
    }
}

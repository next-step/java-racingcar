package camp.nextstep.edu.racingcar.domain;

public class StayOnlyStrategy implements MovingStrategy {
    @Override
    public Integer getDistanceToMove() {
        return 0;
    }
}

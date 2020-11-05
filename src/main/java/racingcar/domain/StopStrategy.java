package racingcar.domain;

public class StopStrategy implements MoveStrategy {
    @Override
    public int getMovingDistance() {
        return 0;
    }
}

package racingcar.domain;

public class ForwardStrategy implements MoveStrategy{
    @Override
    public int getMovingDistance() {
        return 1;
    }
}

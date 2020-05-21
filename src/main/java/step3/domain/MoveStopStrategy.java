package step3.domain;

public class MoveStopStrategy implements MoveStrategy {

    private static final int STOP_DISTANCE = 0;

    @Override
    public int getDistance() {
        return STOP_DISTANCE;
    }
}

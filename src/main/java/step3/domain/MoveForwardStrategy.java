package step3.domain;

public class MoveForwardStrategy implements MoveStrategy {

    private static final int FORWARD_DISTANCE = 1;

    @Override
    public int getDistance() {
        return FORWARD_DISTANCE;
    }
}

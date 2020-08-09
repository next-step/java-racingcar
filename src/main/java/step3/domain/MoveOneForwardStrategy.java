package step3.domain;

public class MoveOneForwardStrategy implements ForwardStrategy {

    private static final int MOVE = 1;

    @Override
    public int calculateForwardDistance() {
        return MOVE;
    }

}

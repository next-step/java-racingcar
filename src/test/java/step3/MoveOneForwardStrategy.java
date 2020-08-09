package step3;

import step3.domain.ForwardStrategy;

public class MoveOneForwardStrategy implements ForwardStrategy {

    private static final int MOVE = 1;

    @Override
    public int calculateForwardDistance() {
        return MOVE;
    }

}

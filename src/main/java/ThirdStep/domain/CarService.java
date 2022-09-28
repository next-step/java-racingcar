package ThirdStep.domain;

import ThirdStep.domain.strategy.MovingStrategy;
public class CarService {

    private static final int MOVE_FORWARD_VALUE = 1;
    private static final int STAY_VALUE = 0;

    public static int movedDistance(MovingStrategy movingStrategy) {
        if (movingStrategy.canMoveForward()) {
            return MOVE_FORWARD_VALUE;
        }
        return STAY_VALUE;
    }
}

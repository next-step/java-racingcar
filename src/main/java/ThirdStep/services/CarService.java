package ThirdStep.services;

import ThirdStep.interfaces.MovingCondition;
public class CarService {

    private static final int MOVE_FORWARD_VALUE = 1;
    private static final int STAY_VALUE = 0;

    public static int movedDistance(MovingCondition movingCondition) {
        if (movingCondition.canMoveForward()) {
            return MOVE_FORWARD_VALUE;
        }
        return STAY_VALUE;
    }
}

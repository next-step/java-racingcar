package racingversion2.car.util;

public class MoveDecider {

    private final static int MINIMUM_MOVABLE_VALUE = 4;

    public static boolean isMovingForwardCondition(int random) {
        return random >= MINIMUM_MOVABLE_VALUE;
    }

}

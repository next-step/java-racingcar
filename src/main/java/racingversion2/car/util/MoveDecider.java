package racingversion2.car.util;

public class MoveDecider {

    private final static int MINIMUM_MOVABLE_VALUE = 4;

    public static boolean isMovingForwardCondition(){
        return RandomValueGenerator.generateRandomValue() >= MINIMUM_MOVABLE_VALUE;
    }

}

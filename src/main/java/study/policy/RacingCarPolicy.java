package study.policy;

public class RacingCarPolicy {
    private static final int MOVING_CONDITION = 4;

    public static boolean canMovingCar(int num) {
        return num >= MOVING_CONDITION;
    }
}

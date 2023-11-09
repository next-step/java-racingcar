package study.racing;

public class RacingCarPolicy {
    private static final int MOVING_CONDITION = 4;

    public static boolean canMovingCar(int num) {
        if (num >= MOVING_CONDITION) {
            return true;
        }
        return false;
    }
}

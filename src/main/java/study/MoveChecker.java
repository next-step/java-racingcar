package study;

public class MoveChecker {
    private static final int MOVE_BOUNDARY = 4;

    public static boolean canMoveForward(int number) {
        if (number >= MOVE_BOUNDARY) {
            return true;
        }
        return false;
    }

}

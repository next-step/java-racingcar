package study.utils;

public class MoveChecker {
    private static final int MOVE_BOUNDARY = 4;

    public static boolean canMoveForward(int number) {
        return number >= MOVE_BOUNDARY;
    }

}

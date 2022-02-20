package util;

public class Ramdom {
    public static final int MOVE_CONDITION_NUMBER = 4;

    public static boolean isMove() {
        return getMoveRandomNumber() >= MOVE_CONDITION_NUMBER;
    }

    private static int getMoveRandomNumber() {
        return (int) ((Math.random() * (10)));
    }
}

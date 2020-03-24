package racing.domain;

public class Movable {
    public static final int MOVE_CONDITION = 4;

    public static boolean isMovable(int randomVal) {
        return randomVal >= MOVE_CONDITION;
    }
}

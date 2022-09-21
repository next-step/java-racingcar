package study.racing.step3;

public interface Movable {
    int MOVE_CONDITION = 4;

    default boolean isMovable(int number) {
        return number >= MOVE_CONDITION;
    }
}

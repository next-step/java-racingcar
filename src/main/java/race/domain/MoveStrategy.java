package race.domain;

public class MoveStrategy {
    private static final int MOVE_CONDITION_NUMBER = 4;

    public boolean isMovable(int number) {
        return number >= MOVE_CONDITION_NUMBER;
    }
}

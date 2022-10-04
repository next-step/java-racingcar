package racing_car_with_winner.model;

public final class GameRule {
    private static final int MOVABLE_CRITERIA = 4;

    public static boolean canMove(int value) {
        return value >= MOVABLE_CRITERIA;
    }
}

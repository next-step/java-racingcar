package race;

public class Car {
    private static final int MOVE_MINIMUM_POWER = 4;

    public static MoveResult move(int power) {
        return MoveResult.of(power >= MOVE_MINIMUM_POWER);
    }
}

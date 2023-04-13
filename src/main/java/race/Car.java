package race;

public class Car {
    private static final int MOVE_MINIMUM_POWER = 4;

    public static boolean move(int power) {
        return power >= MOVE_MINIMUM_POWER;
    }
}

package racinggame.utils;

public class MoveValueValidator {
    public static final int ADVANCED_CONDITION = 4;

    public static boolean validate(int value) {
        return value >= ADVANCED_CONDITION;
    }
}

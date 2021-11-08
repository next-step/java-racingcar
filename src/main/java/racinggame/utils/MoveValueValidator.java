package racinggame.utils;

public class MoveValueValidator {

    private static final int ADVANCED_CONDITION = 4;

    private MoveValueValidator() {
    }

    public static boolean validate(int value) {
        return value >= ADVANCED_CONDITION;
    }
}

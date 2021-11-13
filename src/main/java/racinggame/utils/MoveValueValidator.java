package racinggame.utils;

import racinggame.exception.NotInstanceException;

public class MoveValueValidator {

    private static final int ADVANCED_CONDITION = 4;

    private MoveValueValidator() {
        throw new NotInstanceException();
    }

    public static boolean validate(int value) {
        return value >= ADVANCED_CONDITION;
    }
}

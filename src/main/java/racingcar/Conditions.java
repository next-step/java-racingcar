package racingcar;

import java.util.Arrays;

public class Conditions {

    private static final int MAX_LENGTH = 5;
    private static final int PASS_CONDITION = 4;
    private static final int LOWER_LIMIT = 0;
    private static final int HIGHER_LIMIT = 9;

    private Conditions() { }

    public static boolean isAcceptCondition(int number) {
        return number >= PASS_CONDITION;
    }

    public static boolean isInvalidNumber(int number) {
        return number > HIGHER_LIMIT || number < LOWER_LIMIT;
    }

    public static boolean isInValidName(String carName) {
        return carName.length() > MAX_LENGTH;
    }
}

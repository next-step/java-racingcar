package racingcar.util;

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

    public static void isInValidName(String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("차이름은 5글자 이하만 사용할 수 있습니다.");
        }
    }
}

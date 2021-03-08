package racingcar;

public class Conditions {

    private static final int PASS_CONDITION = 4;
    private static final int LOWER_LIMIT = 0;
    private static final int HIGHER_LIMIT = 9;

    private Conditions() { }

    public static boolean isAcceptCondition(int number) {
        return number >= PASS_CONDITION;
    }

    public static boolean isInvalidate(int number) {
        return number > HIGHER_LIMIT || number < LOWER_LIMIT;
    }
}

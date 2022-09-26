package racingcar;

public class ForwardCondition {
    public static final int LOWEST_BOUND = 0;
    public static final int HIGHEST_BOUND = 10;
    public static final int FORWARD_CONDITION_LOW_BOUND = 4;
    public static final int FORWARD_CONDITION_HIGH_BOUND = 9;

    public static boolean isForwardCondition(int value) {
        return value >= ForwardCondition.FORWARD_CONDITION_LOW_BOUND && value <= ForwardCondition.FORWARD_CONDITION_HIGH_BOUND;
    }
}

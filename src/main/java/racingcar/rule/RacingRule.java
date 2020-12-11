package racingcar.rule;

public interface RacingRule {

    public static final int MIN_VALUE = 0;
    public static final int MAX_BOUND = 10;

    public int getNumber();

    default boolean isWithinRange(int number) {
        return number >= FixedRacingRule.MIN_VALUE && number < FixedRacingRule.MAX_BOUND;
    }

}

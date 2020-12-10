package racingcar.rule;

public class FixedRacingRule implements RacingRule{

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    private int number;

    public FixedRacingRule(int number) {
        if(!isWithinRange(number)) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    public boolean isWithinRange(int number) {
        return number >= FixedRacingRule.MIN_VALUE && number <= FixedRacingRule.MAX_VALUE;
    }
}

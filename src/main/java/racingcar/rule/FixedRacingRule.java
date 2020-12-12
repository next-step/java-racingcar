package racingcar.rule;

public class FixedRacingRule implements RacingRule {

    private final int number;

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
}

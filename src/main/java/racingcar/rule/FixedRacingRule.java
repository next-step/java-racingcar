package racingcar.rule;

public class FixedRacingRule implements RacingRule{

    private int number;

    public FixedRacingRule(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return this.number;
    }
}

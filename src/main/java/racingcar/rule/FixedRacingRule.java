package racingcar.rule;

public class FixedRacingRule implements RacingRule{

    private int number;

    @Override
    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

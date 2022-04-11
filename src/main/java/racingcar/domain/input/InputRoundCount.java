package racingcar.domain.input;

public class InputRoundCount extends PositiveNumber {

    private int roundCount;

    public InputRoundCount(String value) {
        super(value);
        this.roundCount = super.positiveNumber;
    }

    public int getRoundCount() {
        return this.roundCount;
    }
}

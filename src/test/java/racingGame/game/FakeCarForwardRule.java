package racingGame.game;

public class FakeCarForwardRule implements RacingGameRule {

    private static final int CAR_FORWARD_STANDARD = 4;
    private int[] values;
    private int index;

    @Override
    public boolean result() {
        verifyIndex();
        boolean s = values[index] >= CAR_FORWARD_STANDARD;
        index++;
        return s;
    }

    private void verifyIndex() {
        if (index == values.length) {
            index = 0;
        }
    }

    public FakeCarForwardRule(int[] values) {
        this.values = values;
        this.index = 0;
    }
}

package racinggame.input;

public class RacingTryCountInput {
    public static final int MIN_TRY_COUNT = 1;

    private final int trials;

    private RacingTryCountInput(int trials) {
        this.trials = trials;
    }

    public static RacingTryCountInput from(final Integer input) {
        if (input < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도할 회수는 최소 " + MIN_TRY_COUNT + "회 이상이여야 합니다.");
        }

        return new RacingTryCountInput(input);
    }

    public int getTrials() {
        return trials;
    }
}

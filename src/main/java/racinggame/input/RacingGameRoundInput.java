package racinggame.input;

public class RacingGameRoundInput {
    public static final int MIN_ROUND = 1;

    private final int round;

    private RacingGameRoundInput(int round) {
        this.round = round;
    }

    public static RacingGameRoundInput from(final Integer input) {
        if (input < MIN_ROUND) {
            throw new IllegalArgumentException("시도할 회수는 최소 " + MIN_ROUND + "회 이상이여야 합니다.");
        }

        return new RacingGameRoundInput(input);
    }

    public int getRound() {
        return round;
    }
}

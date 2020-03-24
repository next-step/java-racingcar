package racingcar.model;

public final class Round {
    private static final int DEFAULT_ROUND = 0;
    private static final int NEXT = 1;
    private final int round;

    public Round() {
        this.round = DEFAULT_ROUND;
    }

    public Round(final int round) {
        this.round = round;
    }

    public Round next() {
        return new Round(round + NEXT);
    }

    public int getRound() {
        return round;
    }
}

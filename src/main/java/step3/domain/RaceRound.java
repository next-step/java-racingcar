package step3.domain;

public class RaceRound {
    private final int value;

    public RaceRound(int round) {
        this.value = round;
    }

    public static RaceRound of(int round) {
        return new RaceRound(round);
    }

    public int getValue() {
        return value;
    }
}

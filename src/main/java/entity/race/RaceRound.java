package entity.race;

public class RaceRound {

    private final int round;

    private RaceRound(int round) {
        validateRound(round);
        this.round = round;
    }

    private void validateRound(int round) {
        if (round < 0) {
            throw new IllegalArgumentException("라운드는 양수여야 합니다.");
        }
    }

    public static RaceRound of(int round) {
        return new RaceRound(round);
    }

    public int getValue() {
        return round;
    }
}

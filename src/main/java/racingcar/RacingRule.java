package racingcar;

public class RacingRule {

    private static int MOVABLE_NUMBER = 4;
    int round;

    public RacingRule(int round) {
        this.round = round;
    }

    public int getRound() {
        return round;
    }

    public boolean isMovable(int number) {
        return number >= MOVABLE_NUMBER;
    }
}

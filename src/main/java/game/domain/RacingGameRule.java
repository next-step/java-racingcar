package game.domain;

public class RacingGameRule {

    private int canForwardNumber;
    private int bound;
    private static final int forwardDistance = 1;

    public RacingGameRule(int canForwardNumber, int bound) {
        this.canForwardNumber = canForwardNumber;
        this.bound = bound;
    }

    public boolean isForward(int number) {
        return number >= canForwardNumber;
    }

    public int bound() {
        return bound;
    }

    public int canForwardNumber() {
        return canForwardNumber;
    }

    public int forwardDistance() {
        return forwardDistance;
    }

}

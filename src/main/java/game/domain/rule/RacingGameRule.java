package game.domain.rule;

import java.util.Random;

public class RacingGameRule {

    private static final int FORWARD_DISTANCE = 1;
    private int canForwardNumber;
    private Bound bound;

    public RacingGameRule(int canForwardNumber, int bound) {
        this.canForwardNumber = canForwardNumber;
        this.bound = new Bound(bound);
    }

    public boolean isForward(int number) {
        return number >= canForwardNumber;
    }

    public Bound bound() {
        return new Bound(bound);
    }

    public int canForwardNumber() {
        return canForwardNumber;
    }

    public int forwardDistance() {
        return FORWARD_DISTANCE;
    }



}

package game.domain;

import java.util.Random;

public class RacingGameRule {

    private static final int FORWARD_DISTANCE = 1;
    private int canForwardNumber;
    private int bound;

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
        return FORWARD_DISTANCE;
    }



}

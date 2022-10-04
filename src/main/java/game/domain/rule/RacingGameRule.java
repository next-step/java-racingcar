package game.domain.rule;

public class RacingGameRule {

    private static final int FORWARD_DISTANCE = 1;
    private ForwardNumber forwardNumber;
    private Bound bound;

    public RacingGameRule(int canForwardNumber, int bound) {
        this.forwardNumber = new ForwardNumber(canForwardNumber);
        this.bound = new Bound(bound);
    }

    public boolean isForward(int number) {
        return forwardNumber.isForward(number);
    }

    public Bound bound() {
        return new Bound(bound);
    }

    public ForwardNumber forwardNumber() {
        return new ForwardNumber(forwardNumber);
    }

    public int forwardDistance() {
        return FORWARD_DISTANCE;
    }


}

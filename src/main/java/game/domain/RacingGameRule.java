package game.domain;

public class RacingGameRule {

    private int forwardNumber;

    public RacingGameRule(int forwardNumber) {
        this.forwardNumber = forwardNumber;
    }

    public boolean isForward(int number) {
        return number >= forwardNumber;
    }

}

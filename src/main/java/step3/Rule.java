package step3;

public class Rule {

    private int carCount;
    private int roundCount;
    private int initPosition;
    private Limit limit;

    public Rule() {
        this(0, 0, 0);
    }

    public Rule(int initPosition) {
        this(0, 0, initPosition);
    }

    public Rule(int carCount, int roundCount, int initPosition) {
        this.carCount = carCount;
        this.roundCount = roundCount;
        this.limit = limit;
        this.initPosition = initPosition;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public void setRoundCount(int moveCount) {
        this.roundCount = moveCount;
    }

    public void setInitPosition(int initPosition) {
        this.initPosition = initPosition;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    public int getCarCount() {
        return this.carCount;
    }

    public int getRoundCount() {
        return this.roundCount;
    }

    public int getInitPosition() {
        return this.initPosition;
    }

    public Limit getLimit() {
        return this.limit;
    }
}

package step3;

public class Rule {

    private int carCount;
    private int roundCount;
    private Limit limit;

    public Rule(int carCount, int roundCount, Limit limit) {
        this.carCount = carCount;
        this.roundCount = roundCount;
        this.limit = limit;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public void setRoundCount(int moveCount) {
        this.roundCount = moveCount;
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

    public Limit getLimit() {
        return this.limit;
    }
}

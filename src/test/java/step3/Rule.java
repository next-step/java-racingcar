package step3;

public class Rule {

    private int carCount;
    private int roundCount;

    public Rule() {
        this(0, 0);
    }

    public Rule(int carCount, int roundCount) {
        this.carCount = carCount;
        this.roundCount = roundCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public void setRoundCount(int moveCount) {
        this.roundCount = moveCount;
    }

    public int getCarCount() {
        return this.carCount;
    }

    public int getRoundCount() {
        return this.roundCount;
    }

}

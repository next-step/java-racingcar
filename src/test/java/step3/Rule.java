package step3;

public class Rule {

    private int carCount;
    private int moveCount;

    public Rule() {
        this(0, 0);
    }

    public Rule(int carCount, int moveCount) {
        this.carCount = carCount;
        this.moveCount = moveCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public int getCarCount() {
        return this.carCount;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

}

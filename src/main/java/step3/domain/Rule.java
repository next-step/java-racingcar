package step3.domain;

public class Rule {

    private int carCount;
    private int roundCount;
    private int initPosition;
    private int nameLengthLimit;
    private MoveStrategy moveStrategy;

    public Rule(int initPosition, MoveStrategy moveStrategy, int nameLengthLimit) {
        this(0, 0, initPosition, moveStrategy, nameLengthLimit);
    }

    public Rule(int carCount, int roundCount, int initPosition, MoveStrategy moveStrategy,
        int nameLengthLimit) {
        this.carCount = carCount;
        this.roundCount = roundCount;
        this.moveStrategy = moveStrategy;
        this.initPosition = initPosition;
        this.nameLengthLimit = nameLengthLimit;
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

    public void setMovingRule(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
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

    public MoveStrategy getMoveStrategy() {
        return this.moveStrategy;
    }

    public void setNameLengthLimit(int nameLengthLimit) {
        this.nameLengthLimit = nameLengthLimit;
    }

    public int getNameLengthLimit() {
        return nameLengthLimit;
    }
}

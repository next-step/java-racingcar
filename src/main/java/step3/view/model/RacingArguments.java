package step3.view.model;

public class RacingArguments {
    private final int carCount;
    private final int moveCount;

    public RacingArguments(int carCount, int moveCount) {
        this.carCount = carCount;
        this.moveCount = moveCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getMoveCount() {
        return moveCount;
    }
}

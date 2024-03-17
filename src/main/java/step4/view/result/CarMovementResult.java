package step4.view.result;

public class CarMovementResult {
    private final String carName;
    private final int moveCount;

    public CarMovementResult(String carName, int moveCount) {
        this.carName = carName;
        this.moveCount = moveCount;
    }

    public int moveCount() {
        return moveCount;
    }

    public String carName() {
        return carName;
    }
}

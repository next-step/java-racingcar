package step4.view.result;

public class CarMovementResult {
    private final String carName;
    private final int moveCount;

    public static CarMovementResult of(String carName, int moveCount) {
        return new CarMovementResult(carName, moveCount);
    }

    private CarMovementResult(String carName, int moveCount) {
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

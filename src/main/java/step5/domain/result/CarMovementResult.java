package step5.domain.result;

import step5.domain.CarName;

public class CarMovementResult {
    private final CarName carName;
    private final int moveCount;

    public CarMovementResult(String carName, int moveCount) {
        this(new CarName(carName), moveCount);
    }

    public CarMovementResult(CarName carName, int moveCount) {
        this.carName = carName;
        this.moveCount = moveCount;
    }

    public int moveCount() {
        return moveCount;
    }

    public String carName() {
        return carName.value();
    }
}

package step5.domain.result;

import step5.domain.CarName;
import step5.domain.MoveCount;

public class CarMovementResult {
    private final CarName carName;
    private final MoveCount moveCount;

    public CarMovementResult(String carName, int moveCount) {
        this(new CarName(carName), new MoveCount(moveCount));
    }

    public CarMovementResult(CarName carName, MoveCount moveCount) {
        this.carName = carName;
        this.moveCount = moveCount;
    }

    public int moveCount() {
        return moveCount.value();
    }

    public String carName() {
        return carName.value();
    }
}

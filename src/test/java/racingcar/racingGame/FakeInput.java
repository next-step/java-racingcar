package racingcar.racingGame;

import racingcar.Input;

public class FakeInput implements Input {
    private final int carQuantity;
    private final int movementCount;

    public FakeInput(int carQuantity, int movementCount) {
        this.carQuantity = carQuantity;
        this.movementCount = movementCount;
    }

    @Override
    public int getCarQuantity() {
        return this.carQuantity;
    }

    @Override
    public int getMovementCount() {
        return this.movementCount;
    }
}

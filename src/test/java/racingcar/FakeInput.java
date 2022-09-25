package racingcar;

import racingcar.Input;

public class FakeInput implements Input {

    private final Positive carQuantity;
    private final Positive movementCount;

    public FakeInput(Positive carQuantity, Positive movementCount) {
        this.carQuantity = carQuantity;
        this.movementCount = movementCount;
    }

    @Override
    public Positive getCarQuantity() {
        return this.carQuantity;
    }

    @Override
    public Positive getMovementCount() {
        return this.movementCount;
    }

}

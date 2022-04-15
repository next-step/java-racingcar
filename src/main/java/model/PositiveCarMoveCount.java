package model;

import exception.NegativeCarMoveCountException;

public class PositiveCarMoveCount {
    private int carMoveCount;

    private PositiveCarMoveCount() {

    }

    public PositiveCarMoveCount(int carMoveCount) {
        if (carMoveCount <= 0) {
            throw new NegativeCarMoveCountException();
        }

        this.carMoveCount = carMoveCount;
    }

    public int getCarMoveCount() {
        return carMoveCount;
    }
}
